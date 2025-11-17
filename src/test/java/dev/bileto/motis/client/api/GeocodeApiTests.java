package dev.bileto.motis.client.api;

import dev.bileto.motis.client.ApiClient;
import mockwebserver3.Dispatcher;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import mockwebserver3.RecordedRequest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeocodeApiTests {
    private static MockWebServer server;
    private static GeocodeApi api;

    @BeforeAll
    public static void beforeAll() throws IOException {
        server = new MockWebServer();
        server.start();

        var dispatcher = new Dispatcher() {
            @NotNull
            @Override
            public MockResponse dispatch(@NotNull RecordedRequest request) {
                return switch (request.getUrl().encodedPath()) {
                    case "/api/v1/geocode" -> new MockResponse.Builder()
                        .code(200)
                        .addHeader("Content-Type", "application/json")
                        .body("""
                        {
                            "id" : "27888",
                            "name" : "Praha,,Roztyly",
                            "tz" : "Europe/Prague"
                        }
                        """)
                        .build();
                    default ->  new MockResponse.Builder().code(501).build();
                };
            }
        };
        server.setDispatcher(dispatcher);

        api = new GeocodeApi(new ApiClient().setBasePath("http://localhost:%s".formatted(server.getPort())));
    }

    @Test
    public void testGeocodeApi() {
        var matches = api.geocode("Praha", null, null, null, null, null);

        assertNotNull(matches);
        assertEquals(1, matches.size(), "API should return 1 match on geocoding");

        var match = matches.getFirst();
        assertEquals("27888", match.getId(), "API should return 27888 id on geocoding");
        assertTrue(match.getName().startsWith("Praha"), "Match name did not start with Praha");
        assertEquals("Europe/Prague", match.getTz(), "API should return Europe/Prague in TZ");
    }

    @AfterAll
    public static void afterAll() {
        server.close();
    }
}

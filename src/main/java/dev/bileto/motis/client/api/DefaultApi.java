package dev.bileto.motis.client.api;

import dev.bileto.motis.client.ApiClient;

import dev.bileto.motis.client.model.HealthResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.22.0")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * 
     * 
     * <p><b>200</b> - Shows over which feeds at least one cycle of updates was consumed.
     * <p><b>400</b> - Full first cycle through all configured feeds is not finished.
     * @return HealthResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec healthRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<HealthResponse> localVarReturnType = new ParameterizedTypeReference<HealthResponse>() {};
        return apiClient.invokeAPI("/api/v1/health", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - Shows over which feeds at least one cycle of updates was consumed.
     * <p><b>400</b> - Full first cycle through all configured feeds is not finished.
     * @return HealthResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public HealthResponse health() throws WebClientResponseException {
        ParameterizedTypeReference<HealthResponse> localVarReturnType = new ParameterizedTypeReference<HealthResponse>() {};
        return healthRequestCreation().bodyToMono(localVarReturnType).block();
    }

    /**
     * 
     * 
     * <p><b>200</b> - Shows over which feeds at least one cycle of updates was consumed.
     * <p><b>400</b> - Full first cycle through all configured feeds is not finished.
     * @return ResponseEntity&lt;HealthResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HealthResponse> healthWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<HealthResponse> localVarReturnType = new ParameterizedTypeReference<HealthResponse>() {};
        return healthRequestCreation().toEntity(localVarReturnType).block();
    }

    /**
     * 
     * 
     * <p><b>200</b> - Shows over which feeds at least one cycle of updates was consumed.
     * <p><b>400</b> - Full first cycle through all configured feeds is not finished.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec healthWithResponseSpec() throws WebClientResponseException {
        return healthRequestCreation();
    }
}

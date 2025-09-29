package dev.bileto.motis.client.api;

import dev.bileto.motis.client.ApiClient;

import dev.bileto.motis.client.model.Transfers200Response;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.16.0")
public class DebugApi {
    private ApiClient apiClient;

    public DebugApi() {
        this(new ApiClient());
    }

    public DebugApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Prints all transfers of a timetable location (track, bus stop, etc.)
     * 
     * <p><b>200</b> - list of outgoing transfers of this location
     * @param id location id
     * @return Transfers200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec transfersRequestCreation(@jakarta.annotation.Nonnull String id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling transfers", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Transfers200Response> localVarReturnType = new ParameterizedTypeReference<Transfers200Response>() {};
        return apiClient.invokeAPI("/api/debug/transfers", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Prints all transfers of a timetable location (track, bus stop, etc.)
     * 
     * <p><b>200</b> - list of outgoing transfers of this location
     * @param id location id
     * @return Transfers200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Transfers200Response transfers(@jakarta.annotation.Nonnull String id) throws WebClientResponseException {
        ParameterizedTypeReference<Transfers200Response> localVarReturnType = new ParameterizedTypeReference<Transfers200Response>() {};
        return transfersRequestCreation(id).bodyToMono(localVarReturnType).block();
    }

    /**
     * Prints all transfers of a timetable location (track, bus stop, etc.)
     * 
     * <p><b>200</b> - list of outgoing transfers of this location
     * @param id location id
     * @return ResponseEntity&lt;Transfers200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Transfers200Response> transfersWithHttpInfo(@jakarta.annotation.Nonnull String id) throws WebClientResponseException {
        ParameterizedTypeReference<Transfers200Response> localVarReturnType = new ParameterizedTypeReference<Transfers200Response>() {};
        return transfersRequestCreation(id).toEntity(localVarReturnType).block();
    }

    /**
     * Prints all transfers of a timetable location (track, bus stop, etc.)
     * 
     * <p><b>200</b> - list of outgoing transfers of this location
     * @param id location id
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec transfersWithResponseSpec(@jakarta.annotation.Nonnull String id) throws WebClientResponseException {
        return transfersRequestCreation(id);
    }
}

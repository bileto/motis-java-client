package com.bileto.motis.client.api;

import com.bileto.motis.client.ApiClient;

import java.math.BigDecimal;
import com.bileto.motis.client.model.LocationType;
import com.bileto.motis.client.model.Match;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.15.0")
public class GeocodeApi {
    private ApiClient apiClient;

    public GeocodeApi() {
        this(new ApiClient());
    }

    public GeocodeApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Autocompletion &amp; geocoding that resolves user input addresses including coordinates
     * 
     * <p><b>200</b> - A list of guesses to resolve the text to a location
     * @param text the (potentially partially typed) address to resolve
     * @param language language tags as used in OpenStreetMap (usually ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param type Optional. Default is all types.  Only return results of the given types. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @param place Optional. Used for biasing results towards the coordinate.  Format: latitude,longitude in degrees 
     * @param placeBias Optional. Used for biasing results towards the coordinate. Higher number &#x3D; higher bias. 
     * @return List&lt;Match&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec geocodeRequestCreation(@jakarta.annotation.Nonnull String text, @jakarta.annotation.Nullable String language, @jakarta.annotation.Nullable LocationType type, @jakarta.annotation.Nullable String place, @jakarta.annotation.Nullable BigDecimal placeBias) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'text' is set
        if (text == null) {
            throw new WebClientResponseException("Missing the required parameter 'text' when calling geocode", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "text", text));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "place", place));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "placeBias", placeBias));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Match> localVarReturnType = new ParameterizedTypeReference<Match>() {};
        return apiClient.invokeAPI("/api/v1/geocode", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Autocompletion &amp; geocoding that resolves user input addresses including coordinates
     * 
     * <p><b>200</b> - A list of guesses to resolve the text to a location
     * @param text the (potentially partially typed) address to resolve
     * @param language language tags as used in OpenStreetMap (usually ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param type Optional. Default is all types.  Only return results of the given types. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @param place Optional. Used for biasing results towards the coordinate.  Format: latitude,longitude in degrees 
     * @param placeBias Optional. Used for biasing results towards the coordinate. Higher number &#x3D; higher bias. 
     * @return List&lt;Match&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<Match> geocode(@jakarta.annotation.Nonnull String text, @jakarta.annotation.Nullable String language, @jakarta.annotation.Nullable LocationType type, @jakarta.annotation.Nullable String place, @jakarta.annotation.Nullable BigDecimal placeBias) throws WebClientResponseException {
        ParameterizedTypeReference<Match> localVarReturnType = new ParameterizedTypeReference<Match>() {};
        return geocodeRequestCreation(text, language, type, place, placeBias).bodyToFlux(localVarReturnType).collectList().block();
    }

    /**
     * Autocompletion &amp; geocoding that resolves user input addresses including coordinates
     * 
     * <p><b>200</b> - A list of guesses to resolve the text to a location
     * @param text the (potentially partially typed) address to resolve
     * @param language language tags as used in OpenStreetMap (usually ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param type Optional. Default is all types.  Only return results of the given types. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @param place Optional. Used for biasing results towards the coordinate.  Format: latitude,longitude in degrees 
     * @param placeBias Optional. Used for biasing results towards the coordinate. Higher number &#x3D; higher bias. 
     * @return ResponseEntity&lt;List&lt;Match&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Match>> geocodeWithHttpInfo(@jakarta.annotation.Nonnull String text, @jakarta.annotation.Nullable String language, @jakarta.annotation.Nullable LocationType type, @jakarta.annotation.Nullable String place, @jakarta.annotation.Nullable BigDecimal placeBias) throws WebClientResponseException {
        ParameterizedTypeReference<Match> localVarReturnType = new ParameterizedTypeReference<Match>() {};
        return geocodeRequestCreation(text, language, type, place, placeBias).toEntityList(localVarReturnType).block();
    }

    /**
     * Autocompletion &amp; geocoding that resolves user input addresses including coordinates
     * 
     * <p><b>200</b> - A list of guesses to resolve the text to a location
     * @param text the (potentially partially typed) address to resolve
     * @param language language tags as used in OpenStreetMap (usually ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param type Optional. Default is all types.  Only return results of the given types. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @param place Optional. Used for biasing results towards the coordinate.  Format: latitude,longitude in degrees 
     * @param placeBias Optional. Used for biasing results towards the coordinate. Higher number &#x3D; higher bias. 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec geocodeWithResponseSpec(@jakarta.annotation.Nonnull String text, @jakarta.annotation.Nullable String language, @jakarta.annotation.Nullable LocationType type, @jakarta.annotation.Nullable String place, @jakarta.annotation.Nullable BigDecimal placeBias) throws WebClientResponseException {
        return geocodeRequestCreation(text, language, type, place, placeBias);
    }

    /**
     * Translate coordinates to the closest address(es)/places/stops.
     * 
     * <p><b>200</b> - A list of guesses to resolve the coordinates to a location
     * @param place latitude, longitude in degrees
     * @param type Optional. Default is all types.  Only return results of the given type. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @return List&lt;Match&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec reverseGeocodeRequestCreation(@jakarta.annotation.Nonnull String place, @jakarta.annotation.Nullable LocationType type) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'place' is set
        if (place == null) {
            throw new WebClientResponseException("Missing the required parameter 'place' when calling reverseGeocode", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "place", place));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Match> localVarReturnType = new ParameterizedTypeReference<Match>() {};
        return apiClient.invokeAPI("/api/v1/reverse-geocode", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Translate coordinates to the closest address(es)/places/stops.
     * 
     * <p><b>200</b> - A list of guesses to resolve the coordinates to a location
     * @param place latitude, longitude in degrees
     * @param type Optional. Default is all types.  Only return results of the given type. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @return List&lt;Match&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<Match> reverseGeocode(@jakarta.annotation.Nonnull String place, @jakarta.annotation.Nullable LocationType type) throws WebClientResponseException {
        ParameterizedTypeReference<Match> localVarReturnType = new ParameterizedTypeReference<Match>() {};
        return reverseGeocodeRequestCreation(place, type).bodyToFlux(localVarReturnType).collectList().block();
    }

    /**
     * Translate coordinates to the closest address(es)/places/stops.
     * 
     * <p><b>200</b> - A list of guesses to resolve the coordinates to a location
     * @param place latitude, longitude in degrees
     * @param type Optional. Default is all types.  Only return results of the given type. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @return ResponseEntity&lt;List&lt;Match&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Match>> reverseGeocodeWithHttpInfo(@jakarta.annotation.Nonnull String place, @jakarta.annotation.Nullable LocationType type) throws WebClientResponseException {
        ParameterizedTypeReference<Match> localVarReturnType = new ParameterizedTypeReference<Match>() {};
        return reverseGeocodeRequestCreation(place, type).toEntityList(localVarReturnType).block();
    }

    /**
     * Translate coordinates to the closest address(es)/places/stops.
     * 
     * <p><b>200</b> - A list of guesses to resolve the coordinates to a location
     * @param place latitude, longitude in degrees
     * @param type Optional. Default is all types.  Only return results of the given type. For example, this can be used to allow only &#x60;ADDRESS&#x60; and &#x60;STOP&#x60; results. 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec reverseGeocodeWithResponseSpec(@jakarta.annotation.Nonnull String place, @jakarta.annotation.Nullable LocationType type) throws WebClientResponseException {
        return reverseGeocodeRequestCreation(place, type);
    }
}

package dev.bileto.motis.client.api;

import dev.bileto.motis.client.ApiClient;

import java.math.BigDecimal;
import dev.bileto.motis.client.model.Error;
import dev.bileto.motis.client.model.Initial200Response;
import java.time.OffsetDateTime;
import dev.bileto.motis.client.model.Place;
import dev.bileto.motis.client.model.Rentals200Response;
import dev.bileto.motis.client.model.TripSegment;

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
public class MapApi {
    private ApiClient apiClient;

    public MapApi() {
        this(new ApiClient());
    }

    public MapApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * initial location to view the map at after loading based on where public transport should be visible
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - latitude, longitude and zoom level to set the map to
     * @return Initial200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec initialRequestCreation() throws WebClientResponseException {
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

        ParameterizedTypeReference<Initial200Response> localVarReturnType = new ParameterizedTypeReference<Initial200Response>() {};
        return apiClient.invokeAPI("/api/v1/map/initial", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * initial location to view the map at after loading based on where public transport should be visible
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - latitude, longitude and zoom level to set the map to
     * @return Initial200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Initial200Response initial() throws WebClientResponseException {
        ParameterizedTypeReference<Initial200Response> localVarReturnType = new ParameterizedTypeReference<Initial200Response>() {};
        return initialRequestCreation().bodyToMono(localVarReturnType).block();
    }

    /**
     * initial location to view the map at after loading based on where public transport should be visible
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - latitude, longitude and zoom level to set the map to
     * @return ResponseEntity&lt;Initial200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Initial200Response> initialWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<Initial200Response> localVarReturnType = new ParameterizedTypeReference<Initial200Response>() {};
        return initialRequestCreation().toEntity(localVarReturnType).block();
    }

    /**
     * initial location to view the map at after loading based on where public transport should be visible
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - latitude, longitude and zoom level to set the map to
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec initialWithResponseSpec() throws WebClientResponseException {
        return initialRequestCreation();
    }

    /**
     * Get all available levels for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of available levels
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return List&lt;BigDecimal&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec levelsRequestCreation(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'min' is set
        if (min == null) {
            throw new WebClientResponseException("Missing the required parameter 'min' when calling levels", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'max' is set
        if (max == null) {
            throw new WebClientResponseException("Missing the required parameter 'max' when calling levels", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "min", min));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "max", max));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BigDecimal> localVarReturnType = new ParameterizedTypeReference<BigDecimal>() {};
        return apiClient.invokeAPI("/api/v1/map/levels", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all available levels for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of available levels
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return List&lt;BigDecimal&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<BigDecimal> levels(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        ParameterizedTypeReference<BigDecimal> localVarReturnType = new ParameterizedTypeReference<BigDecimal>() {};
        return levelsRequestCreation(min, max).bodyToFlux(localVarReturnType).collectList().block();
    }

    /**
     * Get all available levels for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of available levels
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return ResponseEntity&lt;List&lt;BigDecimal&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<BigDecimal>> levelsWithHttpInfo(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        ParameterizedTypeReference<BigDecimal> localVarReturnType = new ParameterizedTypeReference<BigDecimal>() {};
        return levelsRequestCreation(min, max).toEntityList(localVarReturnType).block();
    }

    /**
     * Get all available levels for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of available levels
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec levelsWithResponseSpec(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        return levelsRequestCreation(min, max);
    }

    /**
     * Get all rental stations and vehicles for a map section or provider
     * If neither the map section (&#x60;min&#x60; and &#x60;max&#x60;) nor the &#x60;providers&#x60; parameter is provided, returns a list of all available rental providers, but no station, vehicle or zone data.  Either the map section (&#x60;min&#x60; and &#x60;max&#x60;) or the &#x60;providers&#x60; parameter must be provided to retrieve station, vehicle and zone data.  If only the map section is provided, all data in the area is returned. If only the &#x60;providers&#x60; parameter is provided, all data for the given providers is returned. If both parameters are provided, only data for the given providers in the map section is returned. 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - Rentals in the map section or for the given providers
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param providers A list of rental providers to return. If empty (the default), all providers in the map section are returned. 
     * @param withStations Optional. Include stations in output (requires at least min+max or providers filter).
     * @param withVehicles Optional. Include free-floating vehicles in output (requires at least min+max or providers filter).
     * @param withZones Optional. Include geofencing zones in output (requires at least min+max or providers filter).
     * @return Rentals200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec rentalsRequestCreation(@jakarta.annotation.Nullable String min, @jakarta.annotation.Nullable String max, @jakarta.annotation.Nullable List<String> providers, @jakarta.annotation.Nullable Boolean withStations, @jakarta.annotation.Nullable Boolean withVehicles, @jakarta.annotation.Nullable Boolean withZones) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "min", min));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "max", max));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "providers", providers));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "withStations", withStations));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "withVehicles", withVehicles));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "withZones", withZones));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Rentals200Response> localVarReturnType = new ParameterizedTypeReference<Rentals200Response>() {};
        return apiClient.invokeAPI("/api/v1/map/rentals", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all rental stations and vehicles for a map section or provider
     * If neither the map section (&#x60;min&#x60; and &#x60;max&#x60;) nor the &#x60;providers&#x60; parameter is provided, returns a list of all available rental providers, but no station, vehicle or zone data.  Either the map section (&#x60;min&#x60; and &#x60;max&#x60;) or the &#x60;providers&#x60; parameter must be provided to retrieve station, vehicle and zone data.  If only the map section is provided, all data in the area is returned. If only the &#x60;providers&#x60; parameter is provided, all data for the given providers is returned. If both parameters are provided, only data for the given providers in the map section is returned. 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - Rentals in the map section or for the given providers
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param providers A list of rental providers to return. If empty (the default), all providers in the map section are returned. 
     * @param withStations Optional. Include stations in output (requires at least min+max or providers filter).
     * @param withVehicles Optional. Include free-floating vehicles in output (requires at least min+max or providers filter).
     * @param withZones Optional. Include geofencing zones in output (requires at least min+max or providers filter).
     * @return Rentals200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Rentals200Response rentals(@jakarta.annotation.Nullable String min, @jakarta.annotation.Nullable String max, @jakarta.annotation.Nullable List<String> providers, @jakarta.annotation.Nullable Boolean withStations, @jakarta.annotation.Nullable Boolean withVehicles, @jakarta.annotation.Nullable Boolean withZones) throws WebClientResponseException {
        ParameterizedTypeReference<Rentals200Response> localVarReturnType = new ParameterizedTypeReference<Rentals200Response>() {};
        return rentalsRequestCreation(min, max, providers, withStations, withVehicles, withZones).bodyToMono(localVarReturnType).block();
    }

    /**
     * Get all rental stations and vehicles for a map section or provider
     * If neither the map section (&#x60;min&#x60; and &#x60;max&#x60;) nor the &#x60;providers&#x60; parameter is provided, returns a list of all available rental providers, but no station, vehicle or zone data.  Either the map section (&#x60;min&#x60; and &#x60;max&#x60;) or the &#x60;providers&#x60; parameter must be provided to retrieve station, vehicle and zone data.  If only the map section is provided, all data in the area is returned. If only the &#x60;providers&#x60; parameter is provided, all data for the given providers is returned. If both parameters are provided, only data for the given providers in the map section is returned. 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - Rentals in the map section or for the given providers
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param providers A list of rental providers to return. If empty (the default), all providers in the map section are returned. 
     * @param withStations Optional. Include stations in output (requires at least min+max or providers filter).
     * @param withVehicles Optional. Include free-floating vehicles in output (requires at least min+max or providers filter).
     * @param withZones Optional. Include geofencing zones in output (requires at least min+max or providers filter).
     * @return ResponseEntity&lt;Rentals200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Rentals200Response> rentalsWithHttpInfo(@jakarta.annotation.Nullable String min, @jakarta.annotation.Nullable String max, @jakarta.annotation.Nullable List<String> providers, @jakarta.annotation.Nullable Boolean withStations, @jakarta.annotation.Nullable Boolean withVehicles, @jakarta.annotation.Nullable Boolean withZones) throws WebClientResponseException {
        ParameterizedTypeReference<Rentals200Response> localVarReturnType = new ParameterizedTypeReference<Rentals200Response>() {};
        return rentalsRequestCreation(min, max, providers, withStations, withVehicles, withZones).toEntity(localVarReturnType).block();
    }

    /**
     * Get all rental stations and vehicles for a map section or provider
     * If neither the map section (&#x60;min&#x60; and &#x60;max&#x60;) nor the &#x60;providers&#x60; parameter is provided, returns a list of all available rental providers, but no station, vehicle or zone data.  Either the map section (&#x60;min&#x60; and &#x60;max&#x60;) or the &#x60;providers&#x60; parameter must be provided to retrieve station, vehicle and zone data.  If only the map section is provided, all data in the area is returned. If only the &#x60;providers&#x60; parameter is provided, all data for the given providers is returned. If both parameters are provided, only data for the given providers in the map section is returned. 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - Rentals in the map section or for the given providers
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param providers A list of rental providers to return. If empty (the default), all providers in the map section are returned. 
     * @param withStations Optional. Include stations in output (requires at least min+max or providers filter).
     * @param withVehicles Optional. Include free-floating vehicles in output (requires at least min+max or providers filter).
     * @param withZones Optional. Include geofencing zones in output (requires at least min+max or providers filter).
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec rentalsWithResponseSpec(@jakarta.annotation.Nullable String min, @jakarta.annotation.Nullable String max, @jakarta.annotation.Nullable List<String> providers, @jakarta.annotation.Nullable Boolean withStations, @jakarta.annotation.Nullable Boolean withVehicles, @jakarta.annotation.Nullable Boolean withZones) throws WebClientResponseException {
        return rentalsRequestCreation(min, max, providers, withStations, withVehicles, withZones);
    }

    /**
     * Get all stops for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of stop places in the selected map section
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return List&lt;Place&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec stopsRequestCreation(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'min' is set
        if (min == null) {
            throw new WebClientResponseException("Missing the required parameter 'min' when calling stops", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'max' is set
        if (max == null) {
            throw new WebClientResponseException("Missing the required parameter 'max' when calling stops", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "min", min));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "max", max));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Place> localVarReturnType = new ParameterizedTypeReference<Place>() {};
        return apiClient.invokeAPI("/api/v1/map/stops", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all stops for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of stop places in the selected map section
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return List&lt;Place&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<Place> stops(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        ParameterizedTypeReference<Place> localVarReturnType = new ParameterizedTypeReference<Place>() {};
        return stopsRequestCreation(min, max).bodyToFlux(localVarReturnType).collectList().block();
    }

    /**
     * Get all stops for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of stop places in the selected map section
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return ResponseEntity&lt;List&lt;Place&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Place>> stopsWithHttpInfo(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        ParameterizedTypeReference<Place> localVarReturnType = new ParameterizedTypeReference<Place>() {};
        return stopsRequestCreation(min, max).toEntityList(localVarReturnType).block();
    }

    /**
     * Get all stops for a map section
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - array of stop places in the selected map section
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec stopsWithResponseSpec(@jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max) throws WebClientResponseException {
        return stopsRequestCreation(min, max);
    }

    /**
     * Given a area frame (box defined by top right and bottom left corner) and a time frame, it returns all trips and their respective shapes that operate in this area + time frame. Trips are filtered by zoom level. On low zoom levels, only long distance trains will be shown while on high zoom levels, also metros, buses and trams will be returned. 
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - a list of trips
     * @param zoom current zoom level
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param startTime start of the time window
     * @param endTime end if the time window
     * @return List&lt;TripSegment&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec tripsRequestCreation(@jakarta.annotation.Nonnull BigDecimal zoom, @jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max, @jakarta.annotation.Nonnull OffsetDateTime startTime, @jakarta.annotation.Nonnull OffsetDateTime endTime) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'zoom' is set
        if (zoom == null) {
            throw new WebClientResponseException("Missing the required parameter 'zoom' when calling trips", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'min' is set
        if (min == null) {
            throw new WebClientResponseException("Missing the required parameter 'min' when calling trips", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'max' is set
        if (max == null) {
            throw new WebClientResponseException("Missing the required parameter 'max' when calling trips", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'startTime' is set
        if (startTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'startTime' when calling trips", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'endTime' is set
        if (endTime == null) {
            throw new WebClientResponseException("Missing the required parameter 'endTime' when calling trips", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "zoom", zoom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "min", min));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "max", max));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startTime", startTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endTime", endTime));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<TripSegment> localVarReturnType = new ParameterizedTypeReference<TripSegment>() {};
        return apiClient.invokeAPI("/api/v5/map/trips", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Given a area frame (box defined by top right and bottom left corner) and a time frame, it returns all trips and their respective shapes that operate in this area + time frame. Trips are filtered by zoom level. On low zoom levels, only long distance trains will be shown while on high zoom levels, also metros, buses and trams will be returned. 
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - a list of trips
     * @param zoom current zoom level
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param startTime start of the time window
     * @param endTime end if the time window
     * @return List&lt;TripSegment&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<TripSegment> trips(@jakarta.annotation.Nonnull BigDecimal zoom, @jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max, @jakarta.annotation.Nonnull OffsetDateTime startTime, @jakarta.annotation.Nonnull OffsetDateTime endTime) throws WebClientResponseException {
        ParameterizedTypeReference<TripSegment> localVarReturnType = new ParameterizedTypeReference<TripSegment>() {};
        return tripsRequestCreation(zoom, min, max, startTime, endTime).bodyToFlux(localVarReturnType).collectList().block();
    }

    /**
     * Given a area frame (box defined by top right and bottom left corner) and a time frame, it returns all trips and their respective shapes that operate in this area + time frame. Trips are filtered by zoom level. On low zoom levels, only long distance trains will be shown while on high zoom levels, also metros, buses and trams will be returned. 
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - a list of trips
     * @param zoom current zoom level
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param startTime start of the time window
     * @param endTime end if the time window
     * @return ResponseEntity&lt;List&lt;TripSegment&gt;&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<TripSegment>> tripsWithHttpInfo(@jakarta.annotation.Nonnull BigDecimal zoom, @jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max, @jakarta.annotation.Nonnull OffsetDateTime startTime, @jakarta.annotation.Nonnull OffsetDateTime endTime) throws WebClientResponseException {
        ParameterizedTypeReference<TripSegment> localVarReturnType = new ParameterizedTypeReference<TripSegment>() {};
        return tripsRequestCreation(zoom, min, max, startTime, endTime).toEntityList(localVarReturnType).block();
    }

    /**
     * Given a area frame (box defined by top right and bottom left corner) and a time frame, it returns all trips and their respective shapes that operate in this area + time frame. Trips are filtered by zoom level. On low zoom levels, only long distance trains will be shown while on high zoom levels, also metros, buses and trams will be returned. 
     * 
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - a list of trips
     * @param zoom current zoom level
     * @param min latitude,longitude pair of the lower right coordinate
     * @param max latitude,longitude pair of the upper left coordinate
     * @param startTime start of the time window
     * @param endTime end if the time window
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec tripsWithResponseSpec(@jakarta.annotation.Nonnull BigDecimal zoom, @jakarta.annotation.Nonnull String min, @jakarta.annotation.Nonnull String max, @jakarta.annotation.Nonnull OffsetDateTime startTime, @jakarta.annotation.Nonnull OffsetDateTime endTime) throws WebClientResponseException {
        return tripsRequestCreation(zoom, min, max, startTime, endTime);
    }
}

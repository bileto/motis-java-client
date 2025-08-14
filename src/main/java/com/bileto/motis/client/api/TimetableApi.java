package com.bileto.motis.client.api;

import com.bileto.motis.client.ApiClient;

import com.bileto.motis.client.model.Itinerary;
import com.bileto.motis.client.model.Mode;
import java.time.OffsetDateTime;
import com.bileto.motis.client.model.Stoptimes200Response;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public class TimetableApi {
    private ApiClient apiClient;

    public TimetableApi() {
        this(new ApiClient());
    }

    public TimetableApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param n the number of events
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return Stoptimes200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec stoptimesRequestCreation(@jakarta.annotation.Nonnull String stopId, @jakarta.annotation.Nonnull Integer n, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'stopId' is set
        if (stopId == null) {
            throw new WebClientResponseException("Missing the required parameter 'stopId' when calling stoptimes", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'n' is set
        if (n == null) {
            throw new WebClientResponseException("Missing the required parameter 'n' when calling stoptimes", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "stopId", stopId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "time", time));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "arriveBy", arriveBy));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "direction", direction));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "mode", mode));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "n", n));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "radius", radius));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exactRadius", exactRadius));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageCursor", pageCursor));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "withScheduledSkippedStops", withScheduledSkippedStops));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Stoptimes200Response> localVarReturnType = new ParameterizedTypeReference<Stoptimes200Response>() {};
        return apiClient.invokeAPI("/api/v4/stoptimes", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param n the number of events
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return Stoptimes200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Stoptimes200Response stoptimes(@jakarta.annotation.Nonnull String stopId, @jakarta.annotation.Nonnull Integer n, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        ParameterizedTypeReference<Stoptimes200Response> localVarReturnType = new ParameterizedTypeReference<Stoptimes200Response>() {};
        return stoptimesRequestCreation(stopId, n, time, arriveBy, direction, mode, radius, exactRadius, pageCursor, withScheduledSkippedStops, language).bodyToMono(localVarReturnType).block();
    }

    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param n the number of events
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseEntity&lt;Stoptimes200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Stoptimes200Response> stoptimesWithHttpInfo(@jakarta.annotation.Nonnull String stopId, @jakarta.annotation.Nonnull Integer n, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        ParameterizedTypeReference<Stoptimes200Response> localVarReturnType = new ParameterizedTypeReference<Stoptimes200Response>() {};
        return stoptimesRequestCreation(stopId, n, time, arriveBy, direction, mode, radius, exactRadius, pageCursor, withScheduledSkippedStops, language).toEntity(localVarReturnType).block();
    }

    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param n the number of events
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec stoptimesWithResponseSpec(@jakarta.annotation.Nonnull String stopId, @jakarta.annotation.Nonnull Integer n, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        return stoptimesRequestCreation(stopId, n, time, arriveBy, direction, mode, radius, exactRadius, pageCursor, withScheduledSkippedStops, language);
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec tripRequestCreation(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'tripId' is set
        if (tripId == null) {
            throw new WebClientResponseException("Missing the required parameter 'tripId' when calling trip", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tripId", tripId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "withScheduledSkippedStops", withScheduledSkippedStops));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "joinInterlinedLegs", joinInterlinedLegs));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return apiClient.invokeAPI("/api/v4/trip", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Itinerary trip(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return tripRequestCreation(tripId, withScheduledSkippedStops, joinInterlinedLegs, language).bodyToMono(localVarReturnType).block();
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseEntity&lt;Itinerary&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Itinerary> tripWithHttpInfo(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return tripRequestCreation(tripId, withScheduledSkippedStops, joinInterlinedLegs, language).toEntity(localVarReturnType).block();
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec tripWithResponseSpec(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable String language) throws WebClientResponseException {
        return tripRequestCreation(tripId, withScheduledSkippedStops, joinInterlinedLegs, language);
    }
}

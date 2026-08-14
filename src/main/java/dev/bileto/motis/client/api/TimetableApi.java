package dev.bileto.motis.client.api;

import dev.bileto.motis.client.ApiClient;

import java.math.BigDecimal;
import dev.bileto.motis.client.model.ElevationCosts;
import dev.bileto.motis.client.model.Error;
import dev.bileto.motis.client.model.Itinerary;
import dev.bileto.motis.client.model.Mode;
import java.time.OffsetDateTime;
import dev.bileto.motis.client.model.PedestrianProfile;
import dev.bileto.motis.client.model.RealtimeMode;
import dev.bileto.motis.client.model.RefreshItineraryPostBody;
import dev.bileto.motis.client.model.RentalFormFactor;
import dev.bileto.motis.client.model.RentalPropulsionType;
import dev.bileto.motis.client.model.StopInfo200Response;
import dev.bileto.motis.client.model.Stoptimes200Response;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.24.0")
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
     * Reconstruct an itinerary from an itinerary ID.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All parameters mirror those of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param itineraryId The itineraryId parameter
     * @param requireDisplayNameMatch The requireDisplayNameMatch parameter
     * @param joinInterlinedLegs The joinInterlinedLegs parameter
     * @param detailedTransfers The detailedTransfers parameter
     * @param detailedLegs The detailedLegs parameter
     * @param withFares The withFares parameter
     * @param withScheduledSkippedStops The withScheduledSkippedStops parameter
     * @param numLegAlternatives The numLegAlternatives parameter
     * @param transitModes The transitModes parameter
     * @param preTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the first (access) mile when reconstructing leg alternatives. Should match the &#x60;preTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param postTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the last (egress) mile when reconstructing leg alternatives. Should match the &#x60;postTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param pedestrianProfile The pedestrianProfile parameter
     * @param useRoutedTransfers The useRoutedTransfers parameter
     * @param requireBikeTransport The requireBikeTransport parameter
     * @param requireCarTransport The requireCarTransport parameter
     * @param noCompulsoryReservation The noCompulsoryReservation parameter
     * @param language The language parameter
     * @param pedestrianSpeed Average speed for pedestrian routing on the first/last mile.
     * @param cyclingSpeed Average speed for bike routing on the first/last mile.
     * @param elevationCosts Elevation cost profile for first/last-mile street routing.
     * @param maxMatchingDistance Maximum matching distance in meters to the street network.  Is limited by server config variable &#x60;max_max_matching_distance&#x60;, larger values are capped to this limit. 
     * @param maxPreTransitTime Maximum time in seconds for the first (access) street leg.
     * @param maxPostTransitTime Maximum time in seconds for the last (egress) street leg.
     * @param preTransitRentalFormFactors Allowed rental form factors for the first (access) leg.
     * @param postTransitRentalFormFactors Allowed rental form factors for the last (egress) leg.
     * @param preTransitRentalPropulsionTypes Allowed rental propulsion types for the first (access) leg.
     * @param postTransitRentalPropulsionTypes Allowed rental propulsion types for the last (egress) leg.
     * @param preTransitRentalProviders Allowed rental providers for the first (access) leg.
     * @param postTransitRentalProviders Allowed rental providers for the last (egress) leg.
     * @param preTransitRentalProviderGroups Allowed rental provider groups for the first (access) leg.
     * @param postTransitRentalProviderGroups Allowed rental provider groups for the last (egress) leg.
     * @param ignorePreTransitRentalReturnConstraints Ignore rental return constraints on the first (access) leg.
     * @param ignorePostTransitRentalReturnConstraints Ignore rental return constraints on the last (egress) leg.
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec refreshItineraryRequestCreation(@jakarta.annotation.Nonnull String itineraryId, @jakarta.annotation.Nullable Boolean requireDisplayNameMatch, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable Boolean detailedTransfers, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean withFares, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Integer numLegAlternatives, @jakarta.annotation.Nullable List<Mode> transitModes, @jakarta.annotation.Nullable List<Mode> preTransitModes, @jakarta.annotation.Nullable List<Mode> postTransitModes, @jakarta.annotation.Nullable PedestrianProfile pedestrianProfile, @jakarta.annotation.Nullable Boolean useRoutedTransfers, @jakarta.annotation.Nullable Boolean requireBikeTransport, @jakarta.annotation.Nullable Boolean requireCarTransport, @jakarta.annotation.Nullable Boolean noCompulsoryReservation, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable BigDecimal pedestrianSpeed, @jakarta.annotation.Nullable BigDecimal cyclingSpeed, @jakarta.annotation.Nullable ElevationCosts elevationCosts, @jakarta.annotation.Nullable BigDecimal maxMatchingDistance, @jakarta.annotation.Nullable Integer maxPreTransitTime, @jakarta.annotation.Nullable Integer maxPostTransitTime, @jakarta.annotation.Nullable List<RentalFormFactor> preTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalFormFactor> postTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalPropulsionType> preTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<RentalPropulsionType> postTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<String> preTransitRentalProviders, @jakarta.annotation.Nullable List<String> postTransitRentalProviders, @jakarta.annotation.Nullable List<String> preTransitRentalProviderGroups, @jakarta.annotation.Nullable List<String> postTransitRentalProviderGroups, @jakarta.annotation.Nullable Boolean ignorePreTransitRentalReturnConstraints, @jakarta.annotation.Nullable Boolean ignorePostTransitRentalReturnConstraints) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'itineraryId' is set
        if (itineraryId == null) {
            throw new WebClientResponseException("Missing the required parameter 'itineraryId' when calling refreshItinerary", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "itineraryId", itineraryId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "requireDisplayNameMatch", requireDisplayNameMatch));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "joinInterlinedLegs", joinInterlinedLegs));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "detailedTransfers", detailedTransfers));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "detailedLegs", detailedLegs));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "withFares", withFares));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "withScheduledSkippedStops", withScheduledSkippedStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "numLegAlternatives", numLegAlternatives));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "transitModes", transitModes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "preTransitModes", preTransitModes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "postTransitModes", postTransitModes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pedestrianProfile", pedestrianProfile));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "useRoutedTransfers", useRoutedTransfers));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "requireBikeTransport", requireBikeTransport));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "requireCarTransport", requireCarTransport));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "noCompulsoryReservation", noCompulsoryReservation));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "language", language));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pedestrianSpeed", pedestrianSpeed));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "cyclingSpeed", cyclingSpeed));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "elevationCosts", elevationCosts));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "maxMatchingDistance", maxMatchingDistance));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "maxPreTransitTime", maxPreTransitTime));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "maxPostTransitTime", maxPostTransitTime));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "preTransitRentalFormFactors", preTransitRentalFormFactors));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "postTransitRentalFormFactors", postTransitRentalFormFactors));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "preTransitRentalPropulsionTypes", preTransitRentalPropulsionTypes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "postTransitRentalPropulsionTypes", postTransitRentalPropulsionTypes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "preTransitRentalProviders", preTransitRentalProviders));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "postTransitRentalProviders", postTransitRentalProviders));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "preTransitRentalProviderGroups", preTransitRentalProviderGroups));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "postTransitRentalProviderGroups", postTransitRentalProviderGroups));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "ignorePreTransitRentalReturnConstraints", ignorePreTransitRentalReturnConstraints));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "ignorePostTransitRentalReturnConstraints", ignorePostTransitRentalReturnConstraints));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return apiClient.invokeAPI("/api/v6/refresh-itinerary", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Reconstruct an itinerary from an itinerary ID.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All parameters mirror those of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param itineraryId The itineraryId parameter
     * @param requireDisplayNameMatch The requireDisplayNameMatch parameter
     * @param joinInterlinedLegs The joinInterlinedLegs parameter
     * @param detailedTransfers The detailedTransfers parameter
     * @param detailedLegs The detailedLegs parameter
     * @param withFares The withFares parameter
     * @param withScheduledSkippedStops The withScheduledSkippedStops parameter
     * @param numLegAlternatives The numLegAlternatives parameter
     * @param transitModes The transitModes parameter
     * @param preTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the first (access) mile when reconstructing leg alternatives. Should match the &#x60;preTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param postTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the last (egress) mile when reconstructing leg alternatives. Should match the &#x60;postTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param pedestrianProfile The pedestrianProfile parameter
     * @param useRoutedTransfers The useRoutedTransfers parameter
     * @param requireBikeTransport The requireBikeTransport parameter
     * @param requireCarTransport The requireCarTransport parameter
     * @param noCompulsoryReservation The noCompulsoryReservation parameter
     * @param language The language parameter
     * @param pedestrianSpeed Average speed for pedestrian routing on the first/last mile.
     * @param cyclingSpeed Average speed for bike routing on the first/last mile.
     * @param elevationCosts Elevation cost profile for first/last-mile street routing.
     * @param maxMatchingDistance Maximum matching distance in meters to the street network.  Is limited by server config variable &#x60;max_max_matching_distance&#x60;, larger values are capped to this limit. 
     * @param maxPreTransitTime Maximum time in seconds for the first (access) street leg.
     * @param maxPostTransitTime Maximum time in seconds for the last (egress) street leg.
     * @param preTransitRentalFormFactors Allowed rental form factors for the first (access) leg.
     * @param postTransitRentalFormFactors Allowed rental form factors for the last (egress) leg.
     * @param preTransitRentalPropulsionTypes Allowed rental propulsion types for the first (access) leg.
     * @param postTransitRentalPropulsionTypes Allowed rental propulsion types for the last (egress) leg.
     * @param preTransitRentalProviders Allowed rental providers for the first (access) leg.
     * @param postTransitRentalProviders Allowed rental providers for the last (egress) leg.
     * @param preTransitRentalProviderGroups Allowed rental provider groups for the first (access) leg.
     * @param postTransitRentalProviderGroups Allowed rental provider groups for the last (egress) leg.
     * @param ignorePreTransitRentalReturnConstraints Ignore rental return constraints on the first (access) leg.
     * @param ignorePostTransitRentalReturnConstraints Ignore rental return constraints on the last (egress) leg.
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Itinerary refreshItinerary(@jakarta.annotation.Nonnull String itineraryId, @jakarta.annotation.Nullable Boolean requireDisplayNameMatch, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable Boolean detailedTransfers, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean withFares, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Integer numLegAlternatives, @jakarta.annotation.Nullable List<Mode> transitModes, @jakarta.annotation.Nullable List<Mode> preTransitModes, @jakarta.annotation.Nullable List<Mode> postTransitModes, @jakarta.annotation.Nullable PedestrianProfile pedestrianProfile, @jakarta.annotation.Nullable Boolean useRoutedTransfers, @jakarta.annotation.Nullable Boolean requireBikeTransport, @jakarta.annotation.Nullable Boolean requireCarTransport, @jakarta.annotation.Nullable Boolean noCompulsoryReservation, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable BigDecimal pedestrianSpeed, @jakarta.annotation.Nullable BigDecimal cyclingSpeed, @jakarta.annotation.Nullable ElevationCosts elevationCosts, @jakarta.annotation.Nullable BigDecimal maxMatchingDistance, @jakarta.annotation.Nullable Integer maxPreTransitTime, @jakarta.annotation.Nullable Integer maxPostTransitTime, @jakarta.annotation.Nullable List<RentalFormFactor> preTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalFormFactor> postTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalPropulsionType> preTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<RentalPropulsionType> postTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<String> preTransitRentalProviders, @jakarta.annotation.Nullable List<String> postTransitRentalProviders, @jakarta.annotation.Nullable List<String> preTransitRentalProviderGroups, @jakarta.annotation.Nullable List<String> postTransitRentalProviderGroups, @jakarta.annotation.Nullable Boolean ignorePreTransitRentalReturnConstraints, @jakarta.annotation.Nullable Boolean ignorePostTransitRentalReturnConstraints) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return refreshItineraryRequestCreation(itineraryId, requireDisplayNameMatch, joinInterlinedLegs, detailedTransfers, detailedLegs, withFares, withScheduledSkippedStops, numLegAlternatives, transitModes, preTransitModes, postTransitModes, pedestrianProfile, useRoutedTransfers, requireBikeTransport, requireCarTransport, noCompulsoryReservation, language, pedestrianSpeed, cyclingSpeed, elevationCosts, maxMatchingDistance, maxPreTransitTime, maxPostTransitTime, preTransitRentalFormFactors, postTransitRentalFormFactors, preTransitRentalPropulsionTypes, postTransitRentalPropulsionTypes, preTransitRentalProviders, postTransitRentalProviders, preTransitRentalProviderGroups, postTransitRentalProviderGroups, ignorePreTransitRentalReturnConstraints, ignorePostTransitRentalReturnConstraints).bodyToMono(localVarReturnType).block();
    }

    /**
     * Reconstruct an itinerary from an itinerary ID.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All parameters mirror those of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param itineraryId The itineraryId parameter
     * @param requireDisplayNameMatch The requireDisplayNameMatch parameter
     * @param joinInterlinedLegs The joinInterlinedLegs parameter
     * @param detailedTransfers The detailedTransfers parameter
     * @param detailedLegs The detailedLegs parameter
     * @param withFares The withFares parameter
     * @param withScheduledSkippedStops The withScheduledSkippedStops parameter
     * @param numLegAlternatives The numLegAlternatives parameter
     * @param transitModes The transitModes parameter
     * @param preTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the first (access) mile when reconstructing leg alternatives. Should match the &#x60;preTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param postTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the last (egress) mile when reconstructing leg alternatives. Should match the &#x60;postTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param pedestrianProfile The pedestrianProfile parameter
     * @param useRoutedTransfers The useRoutedTransfers parameter
     * @param requireBikeTransport The requireBikeTransport parameter
     * @param requireCarTransport The requireCarTransport parameter
     * @param noCompulsoryReservation The noCompulsoryReservation parameter
     * @param language The language parameter
     * @param pedestrianSpeed Average speed for pedestrian routing on the first/last mile.
     * @param cyclingSpeed Average speed for bike routing on the first/last mile.
     * @param elevationCosts Elevation cost profile for first/last-mile street routing.
     * @param maxMatchingDistance Maximum matching distance in meters to the street network.  Is limited by server config variable &#x60;max_max_matching_distance&#x60;, larger values are capped to this limit. 
     * @param maxPreTransitTime Maximum time in seconds for the first (access) street leg.
     * @param maxPostTransitTime Maximum time in seconds for the last (egress) street leg.
     * @param preTransitRentalFormFactors Allowed rental form factors for the first (access) leg.
     * @param postTransitRentalFormFactors Allowed rental form factors for the last (egress) leg.
     * @param preTransitRentalPropulsionTypes Allowed rental propulsion types for the first (access) leg.
     * @param postTransitRentalPropulsionTypes Allowed rental propulsion types for the last (egress) leg.
     * @param preTransitRentalProviders Allowed rental providers for the first (access) leg.
     * @param postTransitRentalProviders Allowed rental providers for the last (egress) leg.
     * @param preTransitRentalProviderGroups Allowed rental provider groups for the first (access) leg.
     * @param postTransitRentalProviderGroups Allowed rental provider groups for the last (egress) leg.
     * @param ignorePreTransitRentalReturnConstraints Ignore rental return constraints on the first (access) leg.
     * @param ignorePostTransitRentalReturnConstraints Ignore rental return constraints on the last (egress) leg.
     * @return ResponseEntity&lt;Itinerary&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Itinerary> refreshItineraryWithHttpInfo(@jakarta.annotation.Nonnull String itineraryId, @jakarta.annotation.Nullable Boolean requireDisplayNameMatch, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable Boolean detailedTransfers, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean withFares, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Integer numLegAlternatives, @jakarta.annotation.Nullable List<Mode> transitModes, @jakarta.annotation.Nullable List<Mode> preTransitModes, @jakarta.annotation.Nullable List<Mode> postTransitModes, @jakarta.annotation.Nullable PedestrianProfile pedestrianProfile, @jakarta.annotation.Nullable Boolean useRoutedTransfers, @jakarta.annotation.Nullable Boolean requireBikeTransport, @jakarta.annotation.Nullable Boolean requireCarTransport, @jakarta.annotation.Nullable Boolean noCompulsoryReservation, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable BigDecimal pedestrianSpeed, @jakarta.annotation.Nullable BigDecimal cyclingSpeed, @jakarta.annotation.Nullable ElevationCosts elevationCosts, @jakarta.annotation.Nullable BigDecimal maxMatchingDistance, @jakarta.annotation.Nullable Integer maxPreTransitTime, @jakarta.annotation.Nullable Integer maxPostTransitTime, @jakarta.annotation.Nullable List<RentalFormFactor> preTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalFormFactor> postTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalPropulsionType> preTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<RentalPropulsionType> postTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<String> preTransitRentalProviders, @jakarta.annotation.Nullable List<String> postTransitRentalProviders, @jakarta.annotation.Nullable List<String> preTransitRentalProviderGroups, @jakarta.annotation.Nullable List<String> postTransitRentalProviderGroups, @jakarta.annotation.Nullable Boolean ignorePreTransitRentalReturnConstraints, @jakarta.annotation.Nullable Boolean ignorePostTransitRentalReturnConstraints) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return refreshItineraryRequestCreation(itineraryId, requireDisplayNameMatch, joinInterlinedLegs, detailedTransfers, detailedLegs, withFares, withScheduledSkippedStops, numLegAlternatives, transitModes, preTransitModes, postTransitModes, pedestrianProfile, useRoutedTransfers, requireBikeTransport, requireCarTransport, noCompulsoryReservation, language, pedestrianSpeed, cyclingSpeed, elevationCosts, maxMatchingDistance, maxPreTransitTime, maxPostTransitTime, preTransitRentalFormFactors, postTransitRentalFormFactors, preTransitRentalPropulsionTypes, postTransitRentalPropulsionTypes, preTransitRentalProviders, postTransitRentalProviders, preTransitRentalProviderGroups, postTransitRentalProviderGroups, ignorePreTransitRentalReturnConstraints, ignorePostTransitRentalReturnConstraints).toEntity(localVarReturnType).block();
    }

    /**
     * Reconstruct an itinerary from an itinerary ID.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All parameters mirror those of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param itineraryId The itineraryId parameter
     * @param requireDisplayNameMatch The requireDisplayNameMatch parameter
     * @param joinInterlinedLegs The joinInterlinedLegs parameter
     * @param detailedTransfers The detailedTransfers parameter
     * @param detailedLegs The detailedLegs parameter
     * @param withFares The withFares parameter
     * @param withScheduledSkippedStops The withScheduledSkippedStops parameter
     * @param numLegAlternatives The numLegAlternatives parameter
     * @param transitModes The transitModes parameter
     * @param preTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the first (access) mile when reconstructing leg alternatives. Should match the &#x60;preTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param postTransitModes Optional. Default is &#x60;WALK&#x60;. Modes allowed for the last (egress) mile when reconstructing leg alternatives. Should match the &#x60;postTransitModes&#x60; of the original &#x60;plan&#x60; request. 
     * @param pedestrianProfile The pedestrianProfile parameter
     * @param useRoutedTransfers The useRoutedTransfers parameter
     * @param requireBikeTransport The requireBikeTransport parameter
     * @param requireCarTransport The requireCarTransport parameter
     * @param noCompulsoryReservation The noCompulsoryReservation parameter
     * @param language The language parameter
     * @param pedestrianSpeed Average speed for pedestrian routing on the first/last mile.
     * @param cyclingSpeed Average speed for bike routing on the first/last mile.
     * @param elevationCosts Elevation cost profile for first/last-mile street routing.
     * @param maxMatchingDistance Maximum matching distance in meters to the street network.  Is limited by server config variable &#x60;max_max_matching_distance&#x60;, larger values are capped to this limit. 
     * @param maxPreTransitTime Maximum time in seconds for the first (access) street leg.
     * @param maxPostTransitTime Maximum time in seconds for the last (egress) street leg.
     * @param preTransitRentalFormFactors Allowed rental form factors for the first (access) leg.
     * @param postTransitRentalFormFactors Allowed rental form factors for the last (egress) leg.
     * @param preTransitRentalPropulsionTypes Allowed rental propulsion types for the first (access) leg.
     * @param postTransitRentalPropulsionTypes Allowed rental propulsion types for the last (egress) leg.
     * @param preTransitRentalProviders Allowed rental providers for the first (access) leg.
     * @param postTransitRentalProviders Allowed rental providers for the last (egress) leg.
     * @param preTransitRentalProviderGroups Allowed rental provider groups for the first (access) leg.
     * @param postTransitRentalProviderGroups Allowed rental provider groups for the last (egress) leg.
     * @param ignorePreTransitRentalReturnConstraints Ignore rental return constraints on the first (access) leg.
     * @param ignorePostTransitRentalReturnConstraints Ignore rental return constraints on the last (egress) leg.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec refreshItineraryWithResponseSpec(@jakarta.annotation.Nonnull String itineraryId, @jakarta.annotation.Nullable Boolean requireDisplayNameMatch, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable Boolean detailedTransfers, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean withFares, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Integer numLegAlternatives, @jakarta.annotation.Nullable List<Mode> transitModes, @jakarta.annotation.Nullable List<Mode> preTransitModes, @jakarta.annotation.Nullable List<Mode> postTransitModes, @jakarta.annotation.Nullable PedestrianProfile pedestrianProfile, @jakarta.annotation.Nullable Boolean useRoutedTransfers, @jakarta.annotation.Nullable Boolean requireBikeTransport, @jakarta.annotation.Nullable Boolean requireCarTransport, @jakarta.annotation.Nullable Boolean noCompulsoryReservation, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable BigDecimal pedestrianSpeed, @jakarta.annotation.Nullable BigDecimal cyclingSpeed, @jakarta.annotation.Nullable ElevationCosts elevationCosts, @jakarta.annotation.Nullable BigDecimal maxMatchingDistance, @jakarta.annotation.Nullable Integer maxPreTransitTime, @jakarta.annotation.Nullable Integer maxPostTransitTime, @jakarta.annotation.Nullable List<RentalFormFactor> preTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalFormFactor> postTransitRentalFormFactors, @jakarta.annotation.Nullable List<RentalPropulsionType> preTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<RentalPropulsionType> postTransitRentalPropulsionTypes, @jakarta.annotation.Nullable List<String> preTransitRentalProviders, @jakarta.annotation.Nullable List<String> postTransitRentalProviders, @jakarta.annotation.Nullable List<String> preTransitRentalProviderGroups, @jakarta.annotation.Nullable List<String> postTransitRentalProviderGroups, @jakarta.annotation.Nullable Boolean ignorePreTransitRentalReturnConstraints, @jakarta.annotation.Nullable Boolean ignorePostTransitRentalReturnConstraints) throws WebClientResponseException {
        return refreshItineraryRequestCreation(itineraryId, requireDisplayNameMatch, joinInterlinedLegs, detailedTransfers, detailedLegs, withFares, withScheduledSkippedStops, numLegAlternatives, transitModes, preTransitModes, postTransitModes, pedestrianProfile, useRoutedTransfers, requireBikeTransport, requireCarTransport, noCompulsoryReservation, language, pedestrianSpeed, cyclingSpeed, elevationCosts, maxMatchingDistance, maxPreTransitTime, maxPostTransitTime, preTransitRentalFormFactors, postTransitRentalFormFactors, preTransitRentalPropulsionTypes, postTransitRentalPropulsionTypes, preTransitRentalProviders, postTransitRentalProviders, preTransitRentalProviderGroups, postTransitRentalProviderGroups, ignorePreTransitRentalReturnConstraints, ignorePostTransitRentalReturnConstraints);
    }

    /**
     * Reconstruct an itinerary from a protobuf-JSON itinerary identifier.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All &#x60;RefreshItineraryPostBody&#x60; fields mirror the parameters of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param refreshItineraryPostBody The refreshItineraryPostBody parameter
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec refreshItineraryPostRequestCreation(@jakarta.annotation.Nonnull RefreshItineraryPostBody refreshItineraryPostBody) throws WebClientResponseException {
        Object postBody = refreshItineraryPostBody;
        // verify the required parameter 'refreshItineraryPostBody' is set
        if (refreshItineraryPostBody == null) {
            throw new WebClientResponseException("Missing the required parameter 'refreshItineraryPostBody' when calling refreshItineraryPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return apiClient.invokeAPI("/api/v6/refresh-itinerary", HttpMethod.POST, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Reconstruct an itinerary from a protobuf-JSON itinerary identifier.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All &#x60;RefreshItineraryPostBody&#x60; fields mirror the parameters of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param refreshItineraryPostBody The refreshItineraryPostBody parameter
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Itinerary refreshItineraryPost(@jakarta.annotation.Nonnull RefreshItineraryPostBody refreshItineraryPostBody) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return refreshItineraryPostRequestCreation(refreshItineraryPostBody).bodyToMono(localVarReturnType).block();
    }

    /**
     * Reconstruct an itinerary from a protobuf-JSON itinerary identifier.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All &#x60;RefreshItineraryPostBody&#x60; fields mirror the parameters of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param refreshItineraryPostBody The refreshItineraryPostBody parameter
     * @return ResponseEntity&lt;Itinerary&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Itinerary> refreshItineraryPostWithHttpInfo(@jakarta.annotation.Nonnull RefreshItineraryPostBody refreshItineraryPostBody) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return refreshItineraryPostRequestCreation(refreshItineraryPostBody).toEntity(localVarReturnType).block();
    }

    /**
     * Reconstruct an itinerary from a protobuf-JSON itinerary identifier.
     * Experimental (API might change without prior notice and without API version bump). Only supports walking at start/end or station-to-station itineraries.  All &#x60;RefreshItineraryPostBody&#x60; fields mirror the parameters of the &#x60;plan&#x60; endpoint - see the &#x60;plan&#x60; endpoint for their descriptions. 
     * <p><b>200</b> - reconstructed itinerary
     * <p><b>400</b> - Bad Request
     * <p><b>500</b> - Internal Server Error
     * @param refreshItineraryPostBody The refreshItineraryPostBody parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec refreshItineraryPostWithResponseSpec(@jakarta.annotation.Nonnull RefreshItineraryPostBody refreshItineraryPostBody) throws WebClientResponseException {
        return refreshItineraryPostRequestCreation(refreshItineraryPostBody);
    }

    /**
     * Get all routes/lines serving a stop (without time-based queries)
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>200</b> - stop information including routes/lines serving the stop(s)
     * @param stopId stop ID as returned by /api/v1/geocode or /api/v1/map/stops
     * @param center latitude,longitude pair used as center for a radius search (used when stopId is not provided; required together with radius if stopId is not given) 
     * @param radius Optional. Radius in meters.  Default is that only routes of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. Required if stopId is not given. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are physically in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return StopInfo200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec stopInfoRequestCreation(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "stopId", stopId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "center", center));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "radius", radius));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "exactRadius", exactRadius));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "language", language));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<StopInfo200Response> localVarReturnType = new ParameterizedTypeReference<StopInfo200Response>() {};
        return apiClient.invokeAPI("/api/v6/stop", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all routes/lines serving a stop (without time-based queries)
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>200</b> - stop information including routes/lines serving the stop(s)
     * @param stopId stop ID as returned by /api/v1/geocode or /api/v1/map/stops
     * @param center latitude,longitude pair used as center for a radius search (used when stopId is not provided; required together with radius if stopId is not given) 
     * @param radius Optional. Radius in meters.  Default is that only routes of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. Required if stopId is not given. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are physically in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return StopInfo200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public StopInfo200Response stopInfo(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        ParameterizedTypeReference<StopInfo200Response> localVarReturnType = new ParameterizedTypeReference<StopInfo200Response>() {};
        return stopInfoRequestCreation(stopId, center, radius, exactRadius, language).bodyToMono(localVarReturnType).block();
    }

    /**
     * Get all routes/lines serving a stop (without time-based queries)
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>200</b> - stop information including routes/lines serving the stop(s)
     * @param stopId stop ID as returned by /api/v1/geocode or /api/v1/map/stops
     * @param center latitude,longitude pair used as center for a radius search (used when stopId is not provided; required together with radius if stopId is not given) 
     * @param radius Optional. Radius in meters.  Default is that only routes of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. Required if stopId is not given. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are physically in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseEntity&lt;StopInfo200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<StopInfo200Response> stopInfoWithHttpInfo(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        ParameterizedTypeReference<StopInfo200Response> localVarReturnType = new ParameterizedTypeReference<StopInfo200Response>() {};
        return stopInfoRequestCreation(stopId, center, radius, exactRadius, language).toEntity(localVarReturnType).block();
    }

    /**
     * Get all routes/lines serving a stop (without time-based queries)
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>200</b> - stop information including routes/lines serving the stop(s)
     * @param stopId stop ID as returned by /api/v1/geocode or /api/v1/map/stops
     * @param center latitude,longitude pair used as center for a radius search (used when stopId is not provided; required together with radius if stopId is not given) 
     * @param radius Optional. Radius in meters.  Default is that only routes of the parent of the stop itself and all stops with the same name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. Required if stopId is not given. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are physically in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with the same name and children are considered. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec stopInfoWithResponseSpec(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        return stopInfoRequestCreation(stopId, center, radius, exactRadius, language);
    }

    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param center Anchor coordinate. Format: latitude,longitude pair. Used as fallback when &#x60;stopId&#x60; is missing or can&#39;t be found. If both are provided and &#x60;stopId&#x60; resolves, &#x60;stopId&#x60; is used. If &#x60;stopId&#x60; does not resolve, &#x60;center&#x60; is used instead. &#x60;radius&#x60; is required when querying by \&quot;center\&quot; (i.e. without a valid &#x60;stopId&#x60;). This can be used to hedge against changing &#x60;stopId&#x60;s. Use with a small &#x60;radius&#x60; and &#x60;exactRadius&#x3D;false&#x60; to still only return the original stop and stops that MOTIS considers equivalent (parent/children or due to similar name, even outside the radius). 
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param both Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, returns both arrivals and departures, ignoring &#x60;arriveBy&#x60;. 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param window Optional. Window in seconds around &#x60;time&#x60;. Limiting the response to those that are at most &#x60;window&#x60; seconds aways in time. If both &#x60;n&#x60; and &#x60;window&#x60; are set, it uses whichever returns more. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param n Minimum number of events to return. If both &#x60;n&#x60; and &#x60;window&#x60; are provided, the API uses whichever returns more events. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with a similar name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with a similar name and children are considered. Use &#x60;exactRadius&#x3D;true&#x60; with &#x60;radius&#x3D;0&#x60; if you really only want to get events for the given &#x60;stopId&#x60; (platform or bay) and nothing from stops considered equivalent. 
     * @param fetchStops Experimental. Expect unannounced breaking changes (without version bumps).  Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, the following stops are returned for departures and the previous stops are returned for arrivals. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param realtimeMode Optional. Default is &#x60;REALTIME&#x60;.  Controls whether realtime data is used. - &#x60;REALTIME&#x60;: realtime data (delays, cancellations) is used   stop times are returned and sorted by their realtime time. - &#x60;REALTIME_ANNOTATION_ONLY&#x60;: stop times are returned, windowed and   sorted by their planned time, but each stop time is annotated with   realtime data. - &#x60;OFF&#x60;: only scheduled data is used; stop times are returned and   sorted by their planned time, with no realtime annotation. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param withAlerts Optional. Default is &#x60;true&#x60;. If set to &#x60;false&#x60;, alerts are omitted in the metadata of place for all stopTimes.
     * @return Stoptimes200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec stoptimesRequestCreation(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable Boolean both, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable Integer window, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer n, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable Boolean fetchStops, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable RealtimeMode realtimeMode, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable Boolean withAlerts) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "stopId", stopId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "center", center));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "time", time));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "arriveBy", arriveBy));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "both", both));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "direction", direction));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "window", window));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "mode", mode));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "n", n));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "radius", radius));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "exactRadius", exactRadius));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "fetchStops", fetchStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageCursor", pageCursor));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "withScheduledSkippedStops", withScheduledSkippedStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "realtimeMode", realtimeMode));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "language", language));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "withAlerts", withAlerts));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Stoptimes200Response> localVarReturnType = new ParameterizedTypeReference<Stoptimes200Response>() {};
        return apiClient.invokeAPI("/api/v6/stoptimes", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param center Anchor coordinate. Format: latitude,longitude pair. Used as fallback when &#x60;stopId&#x60; is missing or can&#39;t be found. If both are provided and &#x60;stopId&#x60; resolves, &#x60;stopId&#x60; is used. If &#x60;stopId&#x60; does not resolve, &#x60;center&#x60; is used instead. &#x60;radius&#x60; is required when querying by \&quot;center\&quot; (i.e. without a valid &#x60;stopId&#x60;). This can be used to hedge against changing &#x60;stopId&#x60;s. Use with a small &#x60;radius&#x60; and &#x60;exactRadius&#x3D;false&#x60; to still only return the original stop and stops that MOTIS considers equivalent (parent/children or due to similar name, even outside the radius). 
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param both Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, returns both arrivals and departures, ignoring &#x60;arriveBy&#x60;. 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param window Optional. Window in seconds around &#x60;time&#x60;. Limiting the response to those that are at most &#x60;window&#x60; seconds aways in time. If both &#x60;n&#x60; and &#x60;window&#x60; are set, it uses whichever returns more. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param n Minimum number of events to return. If both &#x60;n&#x60; and &#x60;window&#x60; are provided, the API uses whichever returns more events. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with a similar name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with a similar name and children are considered. Use &#x60;exactRadius&#x3D;true&#x60; with &#x60;radius&#x3D;0&#x60; if you really only want to get events for the given &#x60;stopId&#x60; (platform or bay) and nothing from stops considered equivalent. 
     * @param fetchStops Experimental. Expect unannounced breaking changes (without version bumps).  Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, the following stops are returned for departures and the previous stops are returned for arrivals. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param realtimeMode Optional. Default is &#x60;REALTIME&#x60;.  Controls whether realtime data is used. - &#x60;REALTIME&#x60;: realtime data (delays, cancellations) is used   stop times are returned and sorted by their realtime time. - &#x60;REALTIME_ANNOTATION_ONLY&#x60;: stop times are returned, windowed and   sorted by their planned time, but each stop time is annotated with   realtime data. - &#x60;OFF&#x60;: only scheduled data is used; stop times are returned and   sorted by their planned time, with no realtime annotation. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param withAlerts Optional. Default is &#x60;true&#x60;. If set to &#x60;false&#x60;, alerts are omitted in the metadata of place for all stopTimes.
     * @return Stoptimes200Response
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Stoptimes200Response stoptimes(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable Boolean both, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable Integer window, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer n, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable Boolean fetchStops, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable RealtimeMode realtimeMode, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable Boolean withAlerts) throws WebClientResponseException {
        ParameterizedTypeReference<Stoptimes200Response> localVarReturnType = new ParameterizedTypeReference<Stoptimes200Response>() {};
        return stoptimesRequestCreation(stopId, center, time, arriveBy, both, direction, window, mode, n, radius, exactRadius, fetchStops, pageCursor, withScheduledSkippedStops, realtimeMode, language, withAlerts).bodyToMono(localVarReturnType).block();
    }

    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param center Anchor coordinate. Format: latitude,longitude pair. Used as fallback when &#x60;stopId&#x60; is missing or can&#39;t be found. If both are provided and &#x60;stopId&#x60; resolves, &#x60;stopId&#x60; is used. If &#x60;stopId&#x60; does not resolve, &#x60;center&#x60; is used instead. &#x60;radius&#x60; is required when querying by \&quot;center\&quot; (i.e. without a valid &#x60;stopId&#x60;). This can be used to hedge against changing &#x60;stopId&#x60;s. Use with a small &#x60;radius&#x60; and &#x60;exactRadius&#x3D;false&#x60; to still only return the original stop and stops that MOTIS considers equivalent (parent/children or due to similar name, even outside the radius). 
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param both Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, returns both arrivals and departures, ignoring &#x60;arriveBy&#x60;. 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param window Optional. Window in seconds around &#x60;time&#x60;. Limiting the response to those that are at most &#x60;window&#x60; seconds aways in time. If both &#x60;n&#x60; and &#x60;window&#x60; are set, it uses whichever returns more. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param n Minimum number of events to return. If both &#x60;n&#x60; and &#x60;window&#x60; are provided, the API uses whichever returns more events. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with a similar name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with a similar name and children are considered. Use &#x60;exactRadius&#x3D;true&#x60; with &#x60;radius&#x3D;0&#x60; if you really only want to get events for the given &#x60;stopId&#x60; (platform or bay) and nothing from stops considered equivalent. 
     * @param fetchStops Experimental. Expect unannounced breaking changes (without version bumps).  Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, the following stops are returned for departures and the previous stops are returned for arrivals. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param realtimeMode Optional. Default is &#x60;REALTIME&#x60;.  Controls whether realtime data is used. - &#x60;REALTIME&#x60;: realtime data (delays, cancellations) is used   stop times are returned and sorted by their realtime time. - &#x60;REALTIME_ANNOTATION_ONLY&#x60;: stop times are returned, windowed and   sorted by their planned time, but each stop time is annotated with   realtime data. - &#x60;OFF&#x60;: only scheduled data is used; stop times are returned and   sorted by their planned time, with no realtime annotation. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param withAlerts Optional. Default is &#x60;true&#x60;. If set to &#x60;false&#x60;, alerts are omitted in the metadata of place for all stopTimes.
     * @return ResponseEntity&lt;Stoptimes200Response&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Stoptimes200Response> stoptimesWithHttpInfo(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable Boolean both, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable Integer window, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer n, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable Boolean fetchStops, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable RealtimeMode realtimeMode, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable Boolean withAlerts) throws WebClientResponseException {
        ParameterizedTypeReference<Stoptimes200Response> localVarReturnType = new ParameterizedTypeReference<Stoptimes200Response>() {};
        return stoptimesRequestCreation(stopId, center, time, arriveBy, both, direction, window, mode, n, radius, exactRadius, fetchStops, pageCursor, withScheduledSkippedStops, realtimeMode, language, withAlerts).toEntity(localVarReturnType).block();
    }

    /**
     * Get the next N departures or arrivals of a stop sorted by time
     * 
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * <p><b>400</b> - Bad Request
     * <p><b>200</b> - A list of departures/arrivals
     * @param stopId stop id of the stop to retrieve departures/arrivals for
     * @param center Anchor coordinate. Format: latitude,longitude pair. Used as fallback when &#x60;stopId&#x60; is missing or can&#39;t be found. If both are provided and &#x60;stopId&#x60; resolves, &#x60;stopId&#x60; is used. If &#x60;stopId&#x60; does not resolve, &#x60;center&#x60; is used instead. &#x60;radius&#x60; is required when querying by \&quot;center\&quot; (i.e. without a valid &#x60;stopId&#x60;). This can be used to hedge against changing &#x60;stopId&#x60;s. Use with a small &#x60;radius&#x60; and &#x60;exactRadius&#x3D;false&#x60; to still only return the original stop and stops that MOTIS considers equivalent (parent/children or due to similar name, even outside the radius). 
     * @param time Optional. Defaults to the current time. 
     * @param arriveBy Optional. Default is &#x60;false&#x60;.    - &#x60;arriveBy&#x3D;true&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the arrival time   - &#x60;arriveBy&#x3D;false&#x60;: the parameters &#x60;date&#x60; and &#x60;time&#x60; refer to the departure time 
     * @param both Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, returns both arrivals and departures, ignoring &#x60;arriveBy&#x60;. 
     * @param direction This parameter will be ignored in case &#x60;pageCursor&#x60; is set.  Optional. Default is   - &#x60;LATER&#x60; for &#x60;arriveBy&#x3D;false&#x60;   - &#x60;EARLIER&#x60; for &#x60;arriveBy&#x3D;true&#x60;  The response will contain the next &#x60;n&#x60; arrivals / departures in case &#x60;EARLIER&#x60; is selected and the previous &#x60;n&#x60; arrivals / departures if &#x60;LATER&#x60; is selected. 
     * @param window Optional. Window in seconds around &#x60;time&#x60;. Limiting the response to those that are at most &#x60;window&#x60; seconds aways in time. If both &#x60;n&#x60; and &#x60;window&#x60; are set, it uses whichever returns more. 
     * @param mode Optional. Default is all transit modes.  Only return arrivals/departures of the given modes. 
     * @param n Minimum number of events to return. If both &#x60;n&#x60; and &#x60;window&#x60; are provided, the API uses whichever returns more events. 
     * @param radius Optional. Radius in meters.  Default is that only stop times of the parent of the stop itself and all stops with a similar name (+ their child stops) are returned.  If set, all stops at parent stations and their child stops in the specified radius are returned. 
     * @param exactRadius Optional. Default is &#x60;false&#x60;.  If set to &#x60;true&#x60;, only stations that are phyiscally in the radius are considered. If set to &#x60;false&#x60;, additionally to the stations in the radius, equivalences with a similar name and children are considered. Use &#x60;exactRadius&#x3D;true&#x60; with &#x60;radius&#x3D;0&#x60; if you really only want to get events for the given &#x60;stopId&#x60; (platform or bay) and nothing from stops considered equivalent. 
     * @param fetchStops Experimental. Expect unannounced breaking changes (without version bumps).  Optional. Default is &#x60;false&#x60;. If set to &#x60;true&#x60;, the following stops are returned for departures and the previous stops are returned for arrivals. 
     * @param pageCursor Use the cursor to go to the next \&quot;page\&quot; of stop times. Copy the cursor from the last response and keep the original request as is. This will enable you to search for stop times in the next or previous time-window. 
     * @param withScheduledSkippedStops Optional. Include stoptimes where passengers can not alight/board according to schedule.
     * @param realtimeMode Optional. Default is &#x60;REALTIME&#x60;.  Controls whether realtime data is used. - &#x60;REALTIME&#x60;: realtime data (delays, cancellations) is used   stop times are returned and sorted by their realtime time. - &#x60;REALTIME_ANNOTATION_ONLY&#x60;: stop times are returned, windowed and   sorted by their planned time, but each stop time is annotated with   realtime data. - &#x60;OFF&#x60;: only scheduled data is used; stop times are returned and   sorted by their planned time, with no realtime annotation. 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @param withAlerts Optional. Default is &#x60;true&#x60;. If set to &#x60;false&#x60;, alerts are omitted in the metadata of place for all stopTimes.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec stoptimesWithResponseSpec(@jakarta.annotation.Nullable String stopId, @jakarta.annotation.Nullable String center, @jakarta.annotation.Nullable OffsetDateTime time, @jakarta.annotation.Nullable Boolean arriveBy, @jakarta.annotation.Nullable Boolean both, @jakarta.annotation.Nullable String direction, @jakarta.annotation.Nullable Integer window, @jakarta.annotation.Nullable List<Mode> mode, @jakarta.annotation.Nullable Integer n, @jakarta.annotation.Nullable Integer radius, @jakarta.annotation.Nullable Boolean exactRadius, @jakarta.annotation.Nullable Boolean fetchStops, @jakarta.annotation.Nullable String pageCursor, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable RealtimeMode realtimeMode, @jakarta.annotation.Nullable List<String> language, @jakarta.annotation.Nullable Boolean withAlerts) throws WebClientResponseException {
        return stoptimesRequestCreation(stopId, center, time, arriveBy, both, direction, window, mode, n, radius, exactRadius, fetchStops, pageCursor, withScheduledSkippedStops, realtimeMode, language, withAlerts);
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param detailedLegs Controls if &#x60;legGeometry&#x60; is returned for transit legs.  The default value is &#x60;true&#x60;. 
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec tripRequestCreation(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'tripId' is set
        if (tripId == null) {
            throw new WebClientResponseException("Missing the required parameter 'tripId' when calling trip", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tripId", tripId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "withScheduledSkippedStops", withScheduledSkippedStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "detailedLegs", detailedLegs));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "joinInterlinedLegs", joinInterlinedLegs));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase(Locale.ROOT)), "language", language));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return apiClient.invokeAPI("/api/v6/trip", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param detailedLegs Controls if &#x60;legGeometry&#x60; is returned for transit legs.  The default value is &#x60;true&#x60;. 
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return Itinerary
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Itinerary trip(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return tripRequestCreation(tripId, withScheduledSkippedStops, detailedLegs, joinInterlinedLegs, language).bodyToMono(localVarReturnType).block();
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param detailedLegs Controls if &#x60;legGeometry&#x60; is returned for transit legs.  The default value is &#x60;true&#x60;. 
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseEntity&lt;Itinerary&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Itinerary> tripWithHttpInfo(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        ParameterizedTypeReference<Itinerary> localVarReturnType = new ParameterizedTypeReference<Itinerary>() {};
        return tripRequestCreation(tripId, withScheduledSkippedStops, detailedLegs, joinInterlinedLegs, language).toEntity(localVarReturnType).block();
    }

    /**
     * Get a trip as itinerary
     * 
     * <p><b>200</b> - the requested trip as itinerary
     * <p><b>422</b> - Unprocessable Entity
     * <p><b>400</b> - Bad Request
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Internal Server Error
     * @param tripId trip identifier (e.g. from an itinerary leg or stop event)
     * @param withScheduledSkippedStops Optional. Include intermediate stops where passengers can not alight/board according to schedule.
     * @param detailedLegs Controls if &#x60;legGeometry&#x60; is returned for transit legs.  The default value is &#x60;true&#x60;. 
     * @param joinInterlinedLegs Optional. Default is &#x60;true&#x60;.  Controls if a trip with stay-seated transfers is returned: - &#x60;joinInterlinedLegs&#x3D;false&#x60;: as several legs (full information about all trip numbers, headsigns, etc.).   Legs that do not require a transfer (stay-seated transfer) are marked with &#x60;interlineWithPreviousLeg&#x3D;true&#x60;. - &#x60;joinInterlinedLegs&#x3D;true&#x60; (default behavior): as only one joined leg containing all stops 
     * @param language language tags as used in OpenStreetMap / GTFS (usually BCP-47 / ISO 639-1, or ISO 639-2 if there&#39;s no ISO 639-1) 
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec tripWithResponseSpec(@jakarta.annotation.Nonnull String tripId, @jakarta.annotation.Nullable Boolean withScheduledSkippedStops, @jakarta.annotation.Nullable Boolean detailedLegs, @jakarta.annotation.Nullable Boolean joinInterlinedLegs, @jakarta.annotation.Nullable List<String> language) throws WebClientResponseException {
        return tripRequestCreation(tripId, withScheduledSkippedStops, detailedLegs, joinInterlinedLegs, language);
    }
}

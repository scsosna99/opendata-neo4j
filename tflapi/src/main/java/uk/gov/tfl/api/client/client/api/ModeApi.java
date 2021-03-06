/*
 * Transport for London Unified API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package uk.gov.tfl.api.client.client.api;

import uk.gov.tfl.api.client.client.ApiCallback;
import uk.gov.tfl.api.client.client.ApiClient;
import uk.gov.tfl.api.client.client.ApiException;
import uk.gov.tfl.api.client.client.ApiResponse;
import uk.gov.tfl.api.client.client.Configuration;
import uk.gov.tfl.api.client.client.Pair;
import uk.gov.tfl.api.client.client.ProgressRequestBody;
import uk.gov.tfl.api.client.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import uk.gov.tfl.api.client.client.model.ActiveServiceType;
import uk.gov.tfl.api.client.client.model.Prediction;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModeApi {
    private ApiClient apiClient;

    public ModeApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ModeApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for modeArrivals
     * @param mode A mode name e.g. tube, dlr (required)
     * @param count A number of arrivals to return for each stop, -1 to return all available. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call modeArrivalsCall(String mode, Integer count, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/Mode/{mode}/Arrivals"
            .replaceAll("\\{" + "mode" + "\\}", apiClient.escapeString(mode.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (count != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("count", count));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json", "application/xml", "text/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call modeArrivalsValidateBeforeCall(String mode, Integer count, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'mode' is set
        if (mode == null) {
            throw new ApiException("Missing the required parameter 'mode' when calling modeArrivals(Async)");
        }
        

        com.squareup.okhttp.Call call = modeArrivalsCall(mode, count, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets the next arrival predictions for all stops of a given mode
     * 
     * @param mode A mode name e.g. tube, dlr (required)
     * @param count A number of arrivals to return for each stop, -1 to return all available. (optional)
     * @return List&lt;Prediction&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Prediction> modeArrivals(String mode, Integer count) throws ApiException {
        ApiResponse<List<Prediction>> resp = modeArrivalsWithHttpInfo(mode, count);
        return resp.getData();
    }

    /**
     * Gets the next arrival predictions for all stops of a given mode
     * 
     * @param mode A mode name e.g. tube, dlr (required)
     * @param count A number of arrivals to return for each stop, -1 to return all available. (optional)
     * @return ApiResponse&lt;List&lt;Prediction&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Prediction>> modeArrivalsWithHttpInfo(String mode, Integer count) throws ApiException {
        com.squareup.okhttp.Call call = modeArrivalsValidateBeforeCall(mode, count, null, null);
        Type localVarReturnType = new TypeToken<List<Prediction>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets the next arrival predictions for all stops of a given mode (asynchronously)
     * 
     * @param mode A mode name e.g. tube, dlr (required)
     * @param count A number of arrivals to return for each stop, -1 to return all available. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call modeArrivalsAsync(String mode, Integer count, final ApiCallback<List<Prediction>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = modeArrivalsValidateBeforeCall(mode, count, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Prediction>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for modeGetActiveServiceTypes
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call modeGetActiveServiceTypesCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/Mode/ActiveServiceTypes";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json", "application/xml", "text/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call modeGetActiveServiceTypesValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = modeGetActiveServiceTypesCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns the service type active for a mode.              Currently only supports tube
     * 
     * @return List&lt;ActiveServiceType&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<ActiveServiceType> modeGetActiveServiceTypes() throws ApiException {
        ApiResponse<List<ActiveServiceType>> resp = modeGetActiveServiceTypesWithHttpInfo();
        return resp.getData();
    }

    /**
     * Returns the service type active for a mode.              Currently only supports tube
     * 
     * @return ApiResponse&lt;List&lt;ActiveServiceType&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<ActiveServiceType>> modeGetActiveServiceTypesWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = modeGetActiveServiceTypesValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<List<ActiveServiceType>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns the service type active for a mode.              Currently only supports tube (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call modeGetActiveServiceTypesAsync(final ApiCallback<List<ActiveServiceType>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = modeGetActiveServiceTypesValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<ActiveServiceType>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}

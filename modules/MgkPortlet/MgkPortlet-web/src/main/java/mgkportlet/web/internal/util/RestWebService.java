package mgkportlet.web.internal.util;

import com.liferay.portal.kernel.util.Validator;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestWebService {

    public HttpURLConnection getBasicHttpURLConnection(String address, String body, String method, String contentType, boolean ignoreCertificate){

        if (ignoreCertificate){
            ignoreCertificate();
        }

        URL url;
        HttpURLConnection conn;
        try {
            url = new URL(address);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod(method);
            if (Validator.isNotNull(contentType)) {
                conn.setRequestProperty("Content-Type", contentType);
            }

            if (Validator.isNotNull(body)){
                OutputStream os = conn.getOutputStream();
                os.write(body.getBytes());
                os.flush();
            }

            conn.connect();

            return conn;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getResponseFromConnection(HttpURLConnection httpURLConnection){
        String response = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (httpURLConnection.getInputStream())));
            String output;
            StringBuilder str = new StringBuilder();
            while ((output = br.readLine()) != null) {
                str.append(output);
            }
            httpURLConnection.disconnect();
            response = str.toString();
        }catch (IOException exception){
            exception.printStackTrace();
        }
        return response;
    }

    public int getResponseCodeFromConnection(HttpURLConnection httpURLConnection){
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String getResponseMessageFromConnection(HttpURLConnection httpURLConnection){
        try {
            return httpURLConnection.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void ignoreCertificate() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }

    }

}





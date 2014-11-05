/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.primemkt.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Jocinardo Rodrigues
 */
public class Send {

    public String To(String Remetente, String Destinatario, String Texto, String Chave, String Senha) throws IOException {
        // URL
        String url = "http://189.6.76.103/Aplicativos/APIv1/Resources/Send.php";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // HEADER
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        // REMENTENTE
        urlParameters.add(new BasicNameValuePair("MessageTo", Remetente));
        // DESTINATARIO
        urlParameters.add(new BasicNameValuePair("MessageFrom", Destinatario));
        // TEXYO
        urlParameters.add(new BasicNameValuePair("MessageText", Texto));
        // PARAMETRO OPCIONAL
        urlParameters.add(new BasicNameValuePair("UserInfo", "0"));
        // PRIORIDADE
        urlParameters.add(new BasicNameValuePair("Priority", "0"));
        // CHAVE
        urlParameters.add(new BasicNameValuePair("KEY_API", Chave));
        // SENHA
        urlParameters.add(new BasicNameValuePair("PASS_API", Senha));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);

        int result = response.getStatusLine().getStatusCode();
        return Integer.toString(result);
    }
}

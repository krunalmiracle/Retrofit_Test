package edu.upc.dsa;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.awt.peer.SystemTrayPeer;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("krunalmiracle");
        try {
            List<Repo> result = repos.execute().body();
            for (Repo r:result) {
                System.out.print(r.toString());
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}

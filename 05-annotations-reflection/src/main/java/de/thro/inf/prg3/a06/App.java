package de.thro.inf.prg3.a06;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws Exception {
		// TODO fetch a random joke and print it to STDOUT
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.chucknorris.io")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		ICNDBApi service = retrofit.create(ICNDBApi.class);

		// todo: code from here
	}

}

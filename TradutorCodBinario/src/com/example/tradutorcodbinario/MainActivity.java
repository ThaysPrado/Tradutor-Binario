package com.example.tradutorcodbinario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText frase;
	private EditText result;
	private Button btnCode;
	private Button btnDecode;
	private String texto;
	private Tradutor trd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		trd = new Tradutor();
		
		frase = (EditText) findViewById(R.id.frase);
		btnCode = (Button) findViewById(R.id.btnCode);
		btnDecode = (Button) findViewById(R.id.btnDecode);
		result = (EditText) findViewById(R.id.result);
		
		btnCode.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				try{
					texto = frase.getText().toString();
					String t = trd.code(texto);
					result.setText(t.toString());
				}
				catch(Exception ex){
					
				}
			}
		});
		
		btnDecode.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				try{
					texto = frase.getText().toString();
					String t = trd.decode(texto);
					result.setText(t.toString());
				}
				catch(Exception ex){
					
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.clear) {
			frase.setText("");
			result.setText("");
			return true;
		}
		if (id == R.id.share) {
			compartilhar(result.getText().toString());
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private void compartilhar(String txt){
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, txt);
		sendIntent.setType("text/plain");
		startActivity(sendIntent);
	}
	
	
	
}

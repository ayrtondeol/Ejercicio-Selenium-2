package test;

import static org.junit.Assert.assertTrue;

import baby.pageObjectBaby;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class babyTest {
		
		pageObjectBaby baby = new pageObjectBaby();
		
		@Given("estoy en google")
		public void estoy_en_google() {
	       baby.abrirGoogle();
		}
		@When("busco la letra de {string}")
		public void busco_la_letra_de(String cancion) {
		    baby.buscarCancion(cancion);
		}
		
		@And("cuento cuantas veces dice {string}")
		public void cuento_cuantas_veces_dice(String algo){
			baby.buscarAlgo(algo);	     
		}
		@Then("obtengo la cantidad de veces que lo dice")
		public void obtengo_la_cantidad_de_veces_que_lo_dice() {
			assertTrue(baby.test());
		}
	}

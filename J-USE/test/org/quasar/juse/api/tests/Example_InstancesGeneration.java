/***********************************************************
 * Filename: MainExample.java
 * Created:  24 de Mar de 2012
 ***********************************************************/
package org.quasar.juse.api.tests;

import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;



import org.quasar.juse.api.JUSE_BasicFacade;
import org.quasar.juse.api.JUSE_ProgramingFacade;
import org.quasar.juse.api.implementation.BasicFacade;
import org.quasar.juse.api.implementation.ProgramingFacade;
import org.tzi.use.uml.ocl.value.EnumValue;
//import org.tzi.use.uml.mm.Annotatable;
//import org.tzi.use.uml.mm.MClass;
//import org.tzi.use.uml.mm.MClassInvariant;
//import org.tzi.use.uml.mm.MElementAnnotation;
//import org.tzi.use.uml.mm.MPrePostCondition;
import org.tzi.use.uml.ocl.value.StringValue;
import org.tzi.use.uml.sys.MLink;
import org.tzi.use.uml.sys.MLinkObject;
import org.tzi.use.uml.sys.MObject;

/***********************************************************
 * @author fba 24 de Mar de 2012
 * 
 ***********************************************************/
public final class Example_InstancesGeneration
{
	private final static String	USE_BASE_DIRECTORY	= "C:/Program Files (x86)/use-3.0.6";

	 private final static String MODEL_DIRECTORY = "D:/Dropbox/TEACH/UML/Exemplos/PT_RUTISEO_Futebol_O";
	 private final static String MODEL_FILE = "CopaPaises_20120416.use";
//	 private final static String SOIL_FILE = "euro2012.soil";

	// private final static String MODEL_DIRECTORY = "D:/Dropbox/TEACH/UML/Exemplos/UK_ProjectWorld";
	// private final static String MODEL_FILE = "ProjectWorld.use";
	// private final static String SOIL_FILE = "projects2.soil";

	

	/***********************************************************
	 * @param args
	 * @throws InterruptedException
	 ***********************************************************/
	public static void main(String[] args) throws InterruptedException
	{
//		 testBasicFacade(args);

//		testProgramingFacade_CopaPaises(args);
		
		testProgramingFacade_CopaPaisesSimplified(args);
	}

	/***********************************************************
	* 
	***********************************************************/
	static void testBasicFacade(String[] args)
	{
		JUSE_BasicFacade api = new BasicFacade();

		api.initialize(args, USE_BASE_DIRECTORY, MODEL_DIRECTORY);

		api.compileSpecification(MODEL_FILE, true);

		api.command("check");

		api.createShell();
	}


	/***********************************************************
	* 
	***********************************************************/
	@SuppressWarnings("unused")
	static void testProgramingFacade_CopaPaises(String[] args)
	{
		JUSE_ProgramingFacade api = new ProgramingFacade();

		api.initialize(args, USE_BASE_DIRECTORY, MODEL_DIRECTORY);

		api.compileSpecification(MODEL_FILE, true);

		api.command("check");

		api.command("info vars");

		MObject ronaldo = api.createObject("ronaldo", api.classByName("Jogador"));
		MObject messi = api.createObject("messi", api.classByName("Jogador"));

		MObject euro2012 = api.createObject("euro2012", api.classByName("Campeonato"));
		MObject spain = api.createObject("spain", api.classByName("Pais"));
		MObject real = api.createObject("real", api.classByName("Clube"));
		MObject barca = api.createObject("barca", api.classByName("Clube"));
		MLinkObject euro2012_spain = api.createLinkObject("euro2012_spain", api.associationClassByName("Participacao"),
						Arrays.asList(spain, euro2012));

		MLink spain_real = api.createLink(api.associationByName("Pais_Clube"), Arrays.asList(spain, real));
		MLink spain_barca = api.createLink(api.associationByName("Pais_Clube"), Arrays.asList(spain, barca));

		MLink ronaldo_real = api.createLink(api.associationByName("Clube_Jogador"), Arrays.asList(real, ronaldo));
		MLink messi_barca = api.createLink(api.associationByName("Clube_Jogador"), Arrays.asList(barca, messi));

		 api.command("info state");

		api.setObjectAttribute(ronaldo, api.attributeByName(ronaldo, "nome"), new StringValue("Cristiano Ronaldo"));

		System.out.println(api.getObjectAttribute(ronaldo, api.attributeByName(ronaldo, "nome")));

		for (MObject clube : api.allInstances(api.classByName("Clube")))
			System.out.println("CLUBE > " + clube);

		for (MObject jogador : api.allInstances(api.classByName("Jogador")))
			System.out.println("JOGADOR > " + jogador);

		// api.createShell();
	}
	
	/***********************************************************
	* 
	***********************************************************/
	@SuppressWarnings("unused")
	static void testProgramingFacade_CopaPaisesSimplified(String[] args)
	{
		JUSE_ProgramingFacade api = new ProgramingFacade();

		api.initialize(args, USE_BASE_DIRECTORY, MODEL_DIRECTORY);

		api.compileSpecification(MODEL_FILE, true);

		api.command("check");

		api.command("info vars");

		MObject ronaldo = api.createObject("ronaldo", "Jogador");
		MObject messi = api.createObject("messi", "Jogador");

		MObject euro2012 = api.createObject("euro2012", "Campeonato");
		MObject spain = api.createObject("spain", "Pais");
		MObject real = api.createObject("real", "Clube");
		MObject barca = api.createObject("barca", "Clube");
		MLinkObject euro2012_spain = api.createLinkObject("euro2012_spain", "Participacao",	Arrays.asList(spain, euro2012));

		MLink spain_real = api.createLink("Pais_Clube", Arrays.asList(spain, real));
		MLink spain_barca = api.createLink("Pais_Clube", Arrays.asList(spain, barca));

		MLink ronaldo_real = api.createLink("Clube_Jogador", Arrays.asList(real, ronaldo));
		MLink messi_barca = api.createLink("Clube_Jogador", Arrays.asList(barca, messi));

		api.command("info state");

		api.setObjectAttribute(ronaldo, api.attributeByName(ronaldo, "nome"), new StringValue("Cristiano Ronaldo"));
		api.setObjectAttribute(ronaldo, api.attributeByName(ronaldo, "posicao"), new EnumValue(api.enumByName("PosicaoJogador"), "Avancado"));
		
		System.out.println(api.getObjectAttribute(ronaldo, api.attributeByName(ronaldo, "nome")));
		System.out.println(api.getObjectAttribute(ronaldo, api.attributeByName(ronaldo, "posicao")));

		for (MObject clube : api.allInstances("Clube"))
			System.out.println("CLUBE > " + clube);

		for (MObject jogador : api.allInstances("Jogador"))
			System.out.println("JOGADOR > " + jogador);

		System.out.println(">"+api.oclEvaluator("Jogador.allInstances->size").toStringWithType()+"<");
		
		// api.createShell();
	}

}
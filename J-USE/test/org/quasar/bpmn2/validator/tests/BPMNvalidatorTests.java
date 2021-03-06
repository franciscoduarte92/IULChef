/***********************************************************
 * Filename: BPMNvalidatorTests.java
 * Created:  28 de Jun de 2012
 ***********************************************************/
package org.quasar.bpmn2.validator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.quasar.juse.api.JUSE_ProgramingFacade;
import org.quasar.juse.api.implementation.ProgramingFacade;
import org.tzi.use.uml.mm.MClassInvariant;

/***********************************************************
 * @author fba 28 de Jun de 2012
 * 
 ***********************************************************/
public class BPMNvalidatorTests {
	private final static String USE_BASE_DIRECTORY = "C:/Program Files (x86)/use-3.0.6";

	private final static String MODEL_DIRECTORY = "D:/Dropbox/_SHARED/Anacleto/Metamodels/BPMN2";
//	private final static String MODEL_DIRECTORY = "D:/tst";
	private final static String MODEL_FILE = "BPMN2.0n.use";
//	private final static String SOIL_DIRECTORY = "TestSuiteModels";

	private static JUSE_ProgramingFacade api = new ProgramingFacade();

	StackTraceElement[] stack = null;
	String methodName = "";

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String[] args = { "-oclAnyCollectionsChecks:I" };

		api.initialize(args, USE_BASE_DIRECTORY, MODEL_DIRECTORY);

		api.compileSpecification(MODEL_FILE, true);

		System.out
				.println("\t# classes = " + api.allClasses().size()
						+ "\t\t# associations = "
						+ api.allAssociations().size() + "\n");
	}

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@Before
	public void setUp() throws Exception {
		System.out
				.println("-------------------------------------------------------------------------------");
	}

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@After
	public void tearDown() {
		// System.out.println("\t# objects = " + api.allObjects().size() +
		// "\t\t# links = " + api.allLinks().size() + "\n");
		try {
			Set<MClassInvariant> failed = getFailedInvariants('S');
			
			if (failed.size() > 1)
				for (MClassInvariant anInvariant : failed)
					printInvariantInfo(anInvariant);
		} catch (Exception e) {
		}
	}


	/***********************************************************
	* @return
	***********************************************************/
	private Set<MClassInvariant> getFailedInvariants(char type)
	{
		Set<MClassInvariant> result = new HashSet<MClassInvariant>();
		for (MClassInvariant anInvariant : api.allInvariants())
		{
			if (!api.check(anInvariant) && invariantValue(anInvariant, "type").charAt(0)==type)
				result.add(anInvariant);
		}
		return result;
	}
	
	/***********************************************************
	* @param invariantName
	* @return
	***********************************************************/
	private boolean invariantFails(String invariantName)
	{
		for (MClassInvariant anInvariant : getFailedInvariants('S'))
		{
			// System.out.println("INVARIANT NAME>" + anInvariant.name() + "<");
			if (anInvariant.name().equals(invariantName))
				return true;
		}
		return false;
	}
	
	private String invariantValue(MClassInvariant anInvariant, String attributeName)
	{
		assertEquals(1, anInvariant.getAllAnnotations().size());

		Set<String> keySet = anInvariant.getAllAnnotations().keySet();
		assertEquals(1, keySet.size());
		
		for (String key : keySet)
				return anInvariant.getAnnotationValue(key, attributeName);
		
		return null;
		}
	
	/***********************************************************
	* @param anInvariant
	***********************************************************/
	private void printInvariantInfo(MClassInvariant anInvariant)
	{
		System.out.print("\tchecking invariant '" + anInvariant.cls().name() + "::" + anInvariant.name() + "' : ");
		if (anInvariant.getAllAnnotations().isEmpty())
			System.out.println("FAIL [Message missing ...]");
		else
			{
				switch (invariantValue(anInvariant, "type").charAt(0))
				{
					case 'S':
						System.out.print("[BPMN2 specification non-conformance]");
						break;
					case 'B':
						System.out.print("[Best practice violation]");
						break;
					case 'I':
						System.out.print("[Information Message]");
						break;
					default:
						System.out.print("UNKNOWN MESSAGE TYPE!!!");
				}
				System.out.print("> " + invariantValue(anInvariant,  "msg"));
				System.out.println(" (" + invariantValue(anInvariant,  "origin") + ")");
			}
	}
	
	/***********************************************************
	* 
	***********************************************************/
	private void testStub() {
		stack = Thread.currentThread().getStackTrace();
		methodName = stack[2].getMethodName();

		System.out.println(">>>" +methodName );

		//api.readSOIL(SOIL_DIRECTORY + "/PASS/",  methodName + ".cmd", true);
		 assertEquals(0, getFailedInvariants('S').size());
		assertTrue(!invariantFails(methodName));

		//api.readSOIL(SOIL_DIRECTORY + "/FAIL/", methodName + ".cmd", true);
		assertTrue(getFailedInvariants('S').size() > 0);
		// System.out.println("DEBUG>" +invariantFails(invariantName));
		assertTrue(invariantFails(methodName));
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void aCollaborationCanOnlyHaveOneInplicitProcess() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void existsCatchSignalEvent() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void topLevelProcessHasRestrictedTypeOfStartEvents() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void callableElementIsReusable() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void messageFlowIsConsistent() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void onlyOneNoneStartEventInSubProcess() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void eventSubProcessTypedStartEventAllowed() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void eventSubProcessesDoNotAllowUntypedStartEvent() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void noIncomingAndOutgoingSequenceFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void mandatoryIncomingOrOutgoingSequenceFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void eventSubProcessAllowedEventType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void nonInterruptingStartEvTypesRestrictedToEventSubProcess() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void boundaryEventAllowedEventType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void intermediateCatchEventAllowedEventType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void intermediateThrowEventAllowedEventType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	// @Test
	// public void endEventAllowedEventType() {
	// testStub();
	// }

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void startEventsHaveNoIncomingSequenceFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void cannotHaveIncomingButHaveOutgoingSequenceFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void endEventsHaveNoOutgoingSequenceFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void incomingMessageFlowHasMessageMultipleType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void multipleIncomingMesgFlowHasMultipleType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void outgoingMessageFlowNotAllowedMessageType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void outgoingMessageFlowHasMessageMultipleType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void multipleOutgoingMesgFlowHasMultipleType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void incomingMessageFlowNotAllowedMessageType() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void catchingLinkEventHasOnlyOutgoingSequenceFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void throwingLinkEventHasOnlyIncomingSequenceFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void nameOfCatchLinkEventsMustBeUnique() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void nameOfThrowLinkEventsMustBeDefined() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void nameOfCatchLinkEventsMustBeDefined() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void namesOfCatchAndThrowLinkEventMustMatch() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void intermediateEventsMustHaveIncAndOutSeqFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void explicitStartEvRequiresNoActivOrGatWithoutInSeqFlow() {
		testStub();
	}

	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void explicitNodeWithoutIncSeqFlowRequiresNoStartEv() {
		testStub();
	}
	/***********************************************************
	* 
	***********************************************************/
	@Test
	public void implicitStartEventsRequiresImplicitEndEvents() {
		testStub();
	}

	
} // end class BPMNvalidatorTests


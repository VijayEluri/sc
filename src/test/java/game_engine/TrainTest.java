package game_engine;

import game_engine.Train;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TrainTest {
	
	@Test
	public void initializingTrainWithLegalValuesShouldPass() {
		Train train = null;
		try {
			train = new Train("2618", "Mangala Lakshadweep Express", "TowardsHome");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		assertNotNull(train);
	}
	
	@Test
	public void verifyTrainDirectionIsSet() {
		Train homeTrain = null;
		Train awayTrain = null;
		try {
			homeTrain = new Train("2618", "Mangala Lakshadweep Express", "TowardsHome");
			awayTrain = new Train("2618", "Mangala Lakshadweep Express", "AwayFromHome");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		assertEquals("Train1 direction was not set properly.", homeTrain.HOME,
				homeTrain.getDirection());
		assertEquals("Train2 direction was not set properly.", awayTrain.AWAY,
				awayTrain.getDirection());
	}
	
	@Test
	public void stationListMustBePopulatedOnInitialization() {
		try {
			Train someTrain = new Train("1097","Poorna Express", "TowardsHome");
			assertTrue("Station list not set.", someTrain.stations.size() > 0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}
	
	@Test
	public void stationListMustBeReversedForTrainsTowardsHome() {
		try {
			Train homeTrain = new Train("1097", "Mangala Lakshadweep Express", "TowardsHome");
			Train awayTrain = new Train("1097", "Mangala Lakshadweep Express", "AwayFromHome");
			assertEquals("Train directions are not reversed.",
				homeTrain.stations.get(0),
				awayTrain.stations.get(awayTrain.stations.size() - 1));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}
	
	@Test
	public void initializingTheTrainShouldStartTheTrainThread() {
		Train train = null;
		try {
			train = new Train("2618", "Mangala Lakshadweep Express", "TowardsHome");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException saxe) {
			saxe.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		assertEquals(Thread.State.RUNNABLE, train.getState());
	}
		
}
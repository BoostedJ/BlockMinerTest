import java.util.ArrayList;

public class HashTest {

    public static void main(String[] args) {

        ArrayList<String> lstWords = new ArrayList<>();
        lstWords.add("word1");
        lstWords.add("word2");
        lstWords.add("word3");
        lstWords.add("word4");

        Util oUtil = new Util();
        String sMerkleRoot = oUtil.getMerkleRoot(lstWords);

        System.out.println("Merkle root: " + sMerkleRoot);

        // ********************************
        // *** BEGIN Multithreaded test ***

        // 1. Create an instance of the target class
        MinerThread oMiner1 = new MinerThread();
        oMiner1.threadName = "Miner 1";
        MinerThread oMiner2 = new MinerThread();
        oMiner2.threadName = "Miner 2";

        // 2. Instantiate a Thread class and pass in the above object
        Thread oThread1 = new Thread(oMiner1);
        Thread oThread2 = new Thread(oMiner2);

        // 3. Call the start method on the Thread instance
        oThread1.start(); // Spawns off the new thread
        oThread2.start();

        System.out.println("This is the main thread.");
    }
}
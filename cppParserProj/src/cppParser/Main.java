package cppParser;

import cppParser.utils.Log;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Extractor e;
        switch(args.length){
            case 0:
                printInstructions();
                break;
            case 1:
                e = new Extractor(args[0]);
                e.process();
                break;
            default:
                try{
                    CmdLineParameterParser.parseParameters(args);
                    System.out.println(CmdLineParameterParser.getInputDir()+" out:"+CmdLineParameterParser.getOutputDir());
                    e = new Extractor(CmdLineParameterParser.getInputDir(),CmdLineParameterParser.outputDir);
                    e.process();
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("Error:"+ex.getMessage());
                    printInstructions();
                }
		// TODO Replace this main function with a call from Prest
        
        }
        /*
		
		*/
	}
    
    private static void printInstructions(){
        System.out.println("Instructions");
        System.out.println(
                "use following parameters: \n"+ 
                "-parse <input directory/file> -out <output directory>\n"+
                "alternatively you can just give input folder as a parameter and \n"+
                 "results are put into same folder where the parser is\n"
                + "-includeStructs parameter can be used to include structs in \n"
                + "addition to classes in the ClassMetrics.csv"
                );
    }

}

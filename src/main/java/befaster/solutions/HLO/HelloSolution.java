package befaster.solutions.HLO;

//import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        StringBuffer sb = new StringBuffer("Hello ").append(friendName);
        return sb.toString();
        //throw new SolutionNotImplementedException();
    }
}


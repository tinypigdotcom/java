
package neato;
public class OutputMgr {
    public Spacer omSpacer;
    public OutputMgr ( ) {
        omSpacer = new Spacer();
    }
    public void omPrint  ( String omLines ) {
        omLines = omLines.replaceAll("(?m)^", omSpacer.getSpace());
        System.out.println( omLines ); // concept: console output
        omSpacer.bumpSpace();
    }
    public void omPrintLines ( String[] lines ) {
        String returnString = "";
        for (String s: lines) {
            System.out.println( omSpacer.getSpace() + s );
        }
        omSpacer.bumpSpace();
    }

}

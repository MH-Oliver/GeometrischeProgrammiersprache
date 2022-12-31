public class
Scanner {
    Repetition mRepetition = new Repetition(1,null);
    public Scanner() {

    }

    public Repetition scanne(String pEingabe) {
        /*char[] pEingabeArray = pEingabe.toCharArray();
        List<Befehl> lBefehlsList = new List<>();

        for (int i = 1;i< pEingabeArray.length;i++) {
            StringBuilder lStringBuilder = new StringBuilder();
            lStringBuilder.append(pEingabeArray[i-1]);
            lStringBuilder.append(pEingabeArray[i]);
            if (lStringBuilder.toString() == "RE") {

                lBefehlsList.append(new Befehl("RE"));
            }
        }*/

        Repetition lRepetition = mRepetition;
        String[] pEingabeArray = pEingabe.split(" ");
        for (int i = 0;i< pEingabeArray.length;++i) {
            if (pEingabeArray[i].equals("RE") && i+1 < pEingabeArray.length) {
                if (istZahl(pEingabeArray[i+1])) lRepetition.mList.append(new Befehl("RE",Integer.parseInt(pEingabeArray[i+1])));
                else return null;
                i = i + 1;
            }
            else if (pEingabeArray[i].equals("LI") && i+1 < pEingabeArray.length) {
                if (istZahl(pEingabeArray[i+1])) lRepetition.mList.append(new Befehl("LE",Integer.parseInt(pEingabeArray[i+1])));
                else return null;
                i = i + 1;
            }
            else if (pEingabeArray[i].equals("VW") && i+1 < pEingabeArray.length) {
                if (istZahl(pEingabeArray[i+1])) lRepetition.mList.append(new Befehl("VW",Integer.parseInt(pEingabeArray[i+1])));
                else return null;
                i = i + 1;
            }
            else if (pEingabeArray[i].equals("WH") && i+2 < pEingabeArray.length) {
                if (istZahl(pEingabeArray[i+1]) && pEingabeArray[i+2].equals("[")) {
                    //System.out.println("Wiederholung erkannt");
                    Repetition lNewRepetition = new Repetition(Integer.parseInt(pEingabeArray[i+1]),lRepetition);
                    lRepetition.mList.append(lNewRepetition);
                    lRepetition = lNewRepetition;


                }
                else return null;
                i = i + 2;

            }
            else if (pEingabeArray[i].equals("]") && lRepetition.mParentRepetition != null) {
                lRepetition = lRepetition.mParentRepetition;
            }
            else return null;


        }
        return mRepetition;
    }

    public static boolean istZahl(String str) {
        // Try to parse the string as a double
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

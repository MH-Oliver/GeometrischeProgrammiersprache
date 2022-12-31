public class Repetition {
    List<Object> mList;

    Repetition mParentRepetition;
    int mWert;
    public Repetition(int pWert,Repetition pParentRepetition) {
        mList = new List<>();
        mParentRepetition = pParentRepetition;
        mWert = pWert;
    }

    public void convertToCommandList(List<Befehl> pCommandList)  {
        for (int i = 0;  i< mWert;++i){
            mList.toFirst();
            while (mList.hasAccess()) {
                if (!(mList.getContent() instanceof Repetition)) {
                    pCommandList.append((Befehl) mList.getContent());
                } else {
                    Repetition lKidRepetition = (Repetition)mList.getContent();
                    lKidRepetition.convertToCommandList(pCommandList);
                }
                mList.next();
            }
        }
    }

}

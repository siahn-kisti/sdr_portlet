package com.sdr.curation.batch.interpret;

public class I_Factory {

    public static I_Interface getInstance(String command) {
        I_Save save = null;

        switch (command.toUpperCase()) {
            case "AWK":
                return new I_Awk();
            case "COPY":
                return new I_Copy();
            case "FIND":
                return new I_Find();
            case "GREP":
                return new I_Grep();
            case "GREP_STRING":
                return new I_GrepString();
            case "GREP_UNDER":
                return new I_GrepUnder();
            case "HEAD":
                return  new I_Head();
            case "REMOVE_FIRST":
                return new I_RemoveFirst();
            case "REMOVE_LAST":
                return new I_RemoveLast();
            case "SAVE":
                return new I_Save();
            case "SAVE_ARRAY":
                save = new I_Save(); save.setFlag(I_Save.FLAG_ARRAY ); return save;
            case "SAVE_2D_ARRAY":
                save = new I_Save(); save.setFlag(I_Save.FLAG_2D_ARRAY ); return save;
            case "SAVE_LABEL_ARRAY":
                save = new I_Save(); save.setFlag(I_Save.FLAG_2D_ARRY_WITH_LABEL ); return save;
            case "SELECT":
                return new I_Select();
            case "SPLIT":
                return new I_Split();
            case "TAIL":
                return new I_Tail();
            default:
                return null;
        }
    }
}

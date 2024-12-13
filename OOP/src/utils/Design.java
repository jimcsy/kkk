package utils;

public class Design {
    public static void header(){
        System.out.println("=====================================================================================");
        System.out.println(" _________                       __      _________               _    _          ");
        System.out.println("|  _   _  |                     [  |  _ |  _   _  |             / |_ (_)         ");
        System.out.println("|_/ | | \\_|_ .--.  ,--.   .---.  | | / ]|_/ | | \\_|,--.   .--. `| |-'__   .---.  ");
        System.out.println("    | |   [ `/'`\\]`'_\\ : / /'`\\] | '' <     | |   `'\\ : ( (`\\ ] | | [  | / /'`\\] ");
        System.out.println("   _| |_   | |    // | |,| \\__.  | |`\\ \\   _| |_  // | |, `'.'. | |, | | | \\__.  ");
        System.out.println("  |_____| [___]   \\'-;__/'.___.'[__|  \\_] |_____| \\'-;__/[\\__) )\\__/[___]'.__.' ");
        System.out.println("=====================================================================================");
    }

    public static void sub(int type){
        switch (type){
            case 1:
                System.out.println("==================================================================");
                System.out.println("                       R E G I S T E R");
                System.out.println("==================================================================");
                break;
            case 2:
                System.out.println("==================================================================");
                System.out.println("                          L O G I N");
                System.out.println("==================================================================");
                break;
            case 3:
                System.out.println("=====================================================================================");
                System.out.println("                       C R E A T I N G  D A I L Y  H A B I T");
                System.out.println("=====================================================================================");
                break; 
            case 4:
                System.out.println("=====================================================================================");
                System.out.println("                       H A B I T  M A N A G E M E N T  M E N U");
                System.out.println("=====================================================================================");
                break; 
            case 5:
                System.out.println("-------------------------------------------------------------------------------------");
                break;
            case 6:
                System.out.println("=====================================================================================");
                System.out.println("                      C R E A T I N G  W E E K L Y  H A B I T");
                System.out.println("=====================================================================================");
                break; 
            case 7:
                System.out.println("==================================================================");
                System.out.println("                     D A I L Y  H A B I T S");
                System.out.println("==================================================================");
                break;
            case 8:
                System.out.println("==================================================================");
                System.out.println("                     W E E K L Y  H A B I T S");
                System.out.println("==================================================================");
                break;
        }
        
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {  
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen.");
        }
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds); 
        } catch (InterruptedException e) {
            System.out.println("The delay was interrupted.");
        }
    }
}

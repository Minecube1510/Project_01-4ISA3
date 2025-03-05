/* Paketan */
package D_Funcer_ReSource;
/* Paketan */


/* Sistem Utama */
public class MegangData {
    private static String terName;
    private static String terNumb;

    // Setter & Getter [nama]
    public static void setNamae(String mengName) {
        MegangData.terName = mengName;
    }
    //
    public static String dapatNamae() {
        return terName;
    }

    // Setter & Getter [telpon]
    public static void setNomor(String mengTelpon) {
        MegangData.terNumb = mengTelpon;
    }
    //
    public static String dapetNomor() {
        return terNumb;
    }
}
/* Sistem Utama */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Scanner;

@XmlRootElement
@XmlType(propOrder = {"isEncrypted", "userData"})
public class CryptKeeper {

    private AES256 theAES256;

    private String userData;

    private String filePath;

    private String fileData;

    private Scanner fileReader;

    private boolean isEncrypted;

    public CryptKeeper() {
        this.theAES256 = new AES256();
    }


    public String getFileData() {
        return fileData;
    }

    @XmlTransient
    public String getFilePath() {
        return filePath;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    @XmlElement(name = "userData")
    public String getUserData() {
        return userData;
    }

    @XmlElement(name = "isEncrypted")
    public boolean getIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Method for opening a file.
    public boolean openReadFile(String filePath) {
        try {
            fileReader = new Scanner(new File(filePath));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public void readFile() {
        // Set file data to empty string each time through as
        // files are read multiple times during the program operations.
        fileData = "";

        StringBuilder sb = new StringBuilder();
        try {
            while (fileReader.hasNextLine()) {
                sb.append(fileReader.nextLine());
                sb.append(System.lineSeparator());
            }
            fileData = sb.toString();
        } catch (Exception e) {
            return;
        }
    }
    public boolean writeDataToXMLFile(String filePath, boolean encryptData) {
        try {
            JAXBContext context = JAXBContext.newInstance(CryptKeeper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Set the state before writing to file
            this.isEncrypted = encryptData;

            if (encryptData) {
                this.userData = AES256.encrypt(userData, "mysecret", "123456789");
            } else {
                this.userData = AES256.decrypt(userData, "mysecret", "123456789");
            }

            File file = new File(filePath);
            marshaller.marshal(this, file);
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static CryptKeeper readDataFromXMLFile(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(CryptKeeper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (CryptKeeper) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            System.err.println("Unmarshalling data error **** NOTE DELETE LATER FOR DEBUGGING PURPOSES ONLY");
            return null;
        }
    }

}
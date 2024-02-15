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
import java.util.Scanner;

// The CryptKeeper contains all the methods and attributes required for
// serialization / deserialization and encryption.

// Annotates root element and establishes order which Xml data should be
// written to the xml file.
@XmlRootElement
@XmlType(propOrder = {"isEncrypted", "userData"})
public class CryptKeeper {

    private AES256 theAES256;

    private String userData;

    private String filePath;

    private String fileData;

    private Scanner fileReader;


    // Used to track if the userData is encrypted.
    private boolean isEncrypted;

    // Constructor
    public CryptKeeper() {
        this.theAES256 = new AES256();
    }


    // Getters
    public String getFileData() {
        return fileData;
    }

    @XmlTransient
    public String getFilePath() {
        return filePath;
    }


    @XmlElement(name = "userData")
    public String getUserData() {
        return userData;
    }

    @XmlElement(name = "isEncrypted")
    public boolean getIsEncrypted() {
        return isEncrypted;
    }

    // Setters
    public void setUserData(String userData) {
        this.userData = userData;
    }

    public void setIsEncrypted(boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Method for opening a file // seeing if it exists.
    public boolean openReadFile(String filePath) {
        try {
            fileReader = new Scanner(new File(filePath));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    // Reads a file and saves data to the fileData member variable for later use.
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

    // Encrypts or decrypts data based upon value passed.
    public void encryptOrDecryptUserData(boolean encryptData) {
        // Sets isEncrypted state prior to writing to file
        this.isEncrypted = encryptData;
        if (encryptData) {
            // Notes in a real world application I would ask the user
            // for their secretKey and use something random for the Salt like unix epoch time or a UUID, etc.
            this.userData = AES256.encrypt(userData, "mysecret", "123456789");
        } else {
            this.userData = AES256.decrypt(userData, "mysecret", "123456789");
        }
    }


    // Writes appropriate CryptKeeper attributes to an XML file.
    public boolean writeDataToXMLFile(String filePath, boolean encryptData) {
        try {
            JAXBContext context = JAXBContext.newInstance(CryptKeeper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            encryptOrDecryptUserData(encryptData);

            File file = new File(filePath);
            marshaller.marshal(this, file);
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Reads marshalled data from an XML file
    public static CryptKeeper readDataFromXMLFile(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(CryptKeeper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (CryptKeeper) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            return null;
        }
    }

}
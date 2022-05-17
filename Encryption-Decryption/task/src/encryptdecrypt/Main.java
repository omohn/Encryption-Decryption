package encryptdecrypt;

public class Main {



    public static void main(String[] args) {

        String output;

        CryptoMethod cryptoMethod = new UnicodeCryptoMethod();


        String mode = "enc";
        int key = 0;
        String data = "";
        String fileOut = "";
        String fileIn = "";
        String algorithm = "unicode";

        for (int i = 0; i < args.length - 1; i++) {
            int j = i + 1;
            switch (args[i]) {
                case "-mode": mode = args[j];
                break;
                case "-key": key = Integer.parseInt(args[j]);
                break;
                case "-data": data = args[j];
                break;
                case "-in": fileIn = args[j];
                break;
                case "-out": fileOut = args[j];
                break;
                case "-alg": algorithm = args[j];
                default: break;

            }

        }

        if ("shift".equals(algorithm)) {
            cryptoMethod = new ShiftCryptoMethod();
        } else if ("unicode".equals(algorithm)) {
            cryptoMethod = new UnicodeCryptoMethod();
        }
        if ("".equals(data) && !"".equals(fileIn)) {
            data = FileReader.readFileData(fileIn);
        }
        if("dec".equals(mode)) {
            output = cryptoMethod.decryptMessage(data, key);
        } else {
            output = cryptoMethod.encryptMessage(data, key);
        }
        if (!"".equals(fileOut)) {
            FileWriter.writeFileData(fileOut, output);
        } else {

            System.out.println(output);
        }


    }


}

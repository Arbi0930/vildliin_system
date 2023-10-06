package lab1;

public class lab1 {
    public static void main(String[] args){
        //Дасгал 1
        int numRow = 80; //Комьпютерийн шугам
        int numColumns = 25; // X багана
        int colorDepthByte = 1; //4 өнгөнд 1 байт


        int videoRamByte = numRow * numColumns * colorDepthByte;

        double videoRAMKB = (double) videoRamByte / 1024;

        System.out.printf("Видео RAM шаардлагатай: %.2f KB\n", videoRAMKB);
        //Дасгал 2

        int numRow2 = 60;
        int numColumns2 = 40;
        int colorDeptByte =1; // 1 байтаар та 256 өөр утгыг илэрхийлэх боломжтой (2^8 = 256).
        // Хэрэв та 4 өөр өнгийг төлөөлөхийг хүсвэл 0-255 хооронд 4 тодорхой утгыг оноож болно.
        //16 өнгөний хувьд танд 2^4 = 16 тул нэг пиксел тутамд 4 бит (хагас байт) хэрэгтэй болно.
        // Гэсэн хэдий ч компьютерууд ихэвчлэн өгөгдлийг бүхэлд нь байтаар хадгалдаг тул та пиксел тутамд
        // 1 байт ашигладаг хэвээр байх болно, гэхдээ та зөвхөн ашиглах болно. Тухайн байт доторх 4 бит
        // өнгийг илэрхийлнэ.
        //16 өнгөнд 1 байт:

        int videoRamByte1 = numRow * numColumns * colorDepthByte;

        double videoRAMKB1 = (double) videoRamByte / 1024;

        System.out.printf("Видео RAM шаардлагатай: %.2f KB\n", videoRAMKB1);

        //Дасгал 3

        // нийт бит = (numpixel * bitpixel)/8

        //2^4 = 16 * 0.5 800*640 pixel бүр 4 бит

        int screenWidth = 800;
        int screenHeight = 600;
        int bitsPerPixel = 4;

        int totalBytes = (screenWidth * screenHeight * bitsPerPixel) / 8;

        double totalKB = (double) totalBytes / 1024;

        System.out.printf("Шаардлагатай нийт санах ой: %.2f KB\n", totalKB);


        //Дасгал 4
        int screenWidth1 = 600;
        int screenHeight1 = 400;
        int bitsPerPixel1 = 8; // 8 бит pixel 256 өнгө=(1byte)
        int totalBytes1 = (screenHeight1 * screenWidth1 * bitsPerPixel1) / 8;

        double totalKB1 = (double) totalBytes1 / 1024;
        System.out.printf("Шаардлагатай санах ой: %.2f КВ\n", totalKB1);


        //Дасгал 5
        int totalPages = 500;
        int linesPerPage = 30;
        int charactersPerLine = 60;
        int cacheSpeed = 1; // 1 ns
        int memorySpeed = 100; // 100 ns
        int diskSpeed = 10000000; // 10 ms in ns

        int totalCharacters = totalPages * linesPerPage * charactersPerLine;

        // Calculate time to check the text in nanoseconds using cache, memory, and disk
        long cacheTime = totalCharacters * cacheSpeed;
        long memoryTime = totalCharacters * memorySpeed;
        long diskTime = totalCharacters * diskSpeed;

        double cacheTimeMS = cacheTime / 1_000_000.0; // nanoseconds to milliseconds
        double memoryTimeMS = memoryTime / 1_000_000.0; // nanoseconds to milliseconds
        double diskTimeMS = diskTime / 1_000_000.0; // nanoseconds to milliseconds


        System.out.println("Текстийг кэш ашиглан шалгах цаг боллоо: " + cacheTimeMS + " ms");
        System.out.println("Time to check text using memory: " + memoryTimeMS + " ms");
        System.out.println("Диск ашиглан текст шалгах цаг: " + diskTimeMS + " ms");

        //Дасгал 6
        int totalPages1 = 100;
        int linesPerPage1 = 20;
        int charactersPerLine1 = 50;
        int cacheSpeed1 = 1; // 1 ns
        int memorySpeed1 = 100; // 100 ns
        int diskSpeed1 = 10000000; // 10 ms in ns

        StringBuilder bookText = generateSampleBookText(totalPages1, linesPerPage1, charactersPerLine1);

        char targetLetter = 'a';

        long cacheTime1 = performLetterResearch(bookText.toString(), targetLetter, cacheSpeed1);
        long memoryTime1 = performLetterResearch(bookText.toString(), targetLetter, memorySpeed1);
        long diskTime1 = performLetterResearch(bookText.toString(), targetLetter, diskSpeed1);

        double cacheTimeMS1 = cacheTime1 / 1_000_000.0; // nanoseconds to milliseconds
        double memoryTimeMS1 = memoryTime1 / 1_000_000.0; // nanoseconds to milliseconds
        double diskTimeMS1 = diskTime1 / 1_000_000.0; // nanoseconds to milliseconds

        // Print the results
        System.out.println("Кэш ашиглан захидал судлах цаг: " + cacheTimeMS1 + " ms");
        System.out.println("Санах ойг ашиглан захидал судлах цаг: " + memoryTimeMS1 + " ms");
        System.out.println("Диск ашиглан захидал судлах цаг: " + diskTimeMS1 + " ms");
    }

    private static StringBuilder generateSampleBookText(int totalPages, int linesPerPage, int charactersPerLine) {
        StringBuilder bookText = new StringBuilder();
        for (int page = 0; page < totalPages; page++) {
            for (int line = 0; line < linesPerPage; line++) {
                for (int charIndex = 0; charIndex < charactersPerLine; charIndex++) {
                    char randomChar = (char) ((int) 'a' + (int) (Math.random() * 26));
                    bookText.append(randomChar);
                }
                bookText.append('\n');
            }
        }
        return bookText;
    }

    private static long performLetterResearch(String text, char targetLetter, int deviceSpeed) {
        long startTime = System.nanoTime();
        for (char c : text.toCharArray()) {
            if (c == targetLetter) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime + deviceSpeed;
    }

 }





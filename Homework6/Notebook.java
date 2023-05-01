public class Notebook {
    // ОЗУ в Мбайтах
    private int ram;
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    // Объем ЖД в Мбайтах
    private int hdd;
    public int getHdd() {
        return hdd;
    }
    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    private String osName;
    public String getOsName() {
        return osName;
    }
    public void setOsName(String osName) {
        this.osName = osName;
    }

    public static class Color {
        public final static Color WHITE     = new Color(255, 255, 255);
        public final static Color BLACK     = new Color(0, 0, 0);
        public final static Color RED       = new Color(255, 0, 0);
        public final static Color GREEN     = new Color(0, 255, 0);
        public final static Color BLUE      = new Color(0, 0, 255);

        private int color;

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
        public Color(int r, int g, int b) {
            color = ((r & 0xFF) << 16) |
                    ((g & 0xFF) << 8)  |
                    ((b & 0xFF) << 0);
        }
        public String colourToString() {
            return String.format("#%08X", color);
        }
    }

    private Color color;
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public Notebook(int ram, int hdd, String osName, Color color) {
        this.ram = ram;
        this.hdd = hdd;
        this.osName = osName;
        this.color = color;
    }
    public Notebook(int ram, int hdd, String osName) {
        this(ram, hdd, osName, Color.BLACK);
    }

    public boolean isSuite(Notebook notebook) {
        return this.ram >= notebook.ram && this.hdd >= notebook.hdd && this.osName.equals(notebook.osName);
    }

    @Override
    public String toString() {
        return "RAM: " + String.valueOf(ram) + "Mb;  "+
               "HDD: " + String.valueOf(hdd) + "Mb;  "+
                "OS Name: " + osName + ";  " +
                "Color: " + color.colourToString();
    }
}

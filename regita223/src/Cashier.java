public class Cashier {
   import java.util.ArrayList;

    public class Cashier {
        private ArrayList<Item> items;

        public Cashier() {
            items = new ArrayList<>();
        }

        public void addItem(double price, String code, String name, int quantity) {
            items.add(new Item(code, name, price, quantity));
            System.out.println("Barang ditambahkan.");
        }

        public void removeItem(String code) {
            for (Item item : items) {
                if (item.getCode().equals(code)) {
                    items.remove(item);
                    System.out.println("Barang dihapus.");
                    return;
                }
            }
            System.out.println("Barang tidak ditemukan.");
        }

        public void viewItems() {
            System.out.println("Daftar barang:");
            for (Item item : items) {
                System.out.printf("Kode: %s, Nama: %s, Harga: %.2f, Jumlah: %d, Subtotal: %.2f\n",
                        item.getCode(), item.getName(), item.getPrice(), item.getQuantity(), item.getSubTotal());
            }
        }

        public void displayTotal() {
            double total = 0.0;
            for (Item item : items) {
                total += item.getSubTotal();
            }
            System.out.println("Total belanja: " + total);
        }

        public double getTotal() {
            double total = 0.0;
            for (Item item : items) {
                total += item.getSubTotal();
            }
            return total;
        }

        public void processPayment(double amountPaid) {
            double total = getTotal();
            if (amountPaid >= total) {
                double change = amountPaid - total;
                System.out.printf("Pembayaran berhasil. Kembali: %.2f\n", change);
            } else {
                System.out.println("Uang tidak cukup.");
            }
        }
    }
}

# PROJECT CONTEXT — SECURE EXAM BROWSER MTs YATABU

## 1. IDENTITAS PROYEK

- Nama aplikasi: Secure Exam Browser
- Institusi: MTs Yatabu
- Package name: `id.mtsyatabu.secureexam`
- Platform: Android
- Bahasa pemrograman: Kotlin
- IDE: Android Studio
- Layout: XML
- Arsitektur: MVVM
- Repository: `secure-exam-mts-yatabu`
- Repository visibility: Private

## 2. TUJUAN APLIKASI

Membuat aplikasi Android sebagai browser khusus untuk membantu pelaksanaan ujian siswa MTs Yatabu.

Aplikasi berfungsi membuka tautan ujian yang sudah disediakan oleh forum Musyawarah Kinerja Kepala Madrasah Kota Surabaya melalui QR Code atau barcode.

Aplikasi ini BUKAN sistem pembuat soal, bank soal, penilaian, atau pengelolaan hasil ujian.

## 3. TEKNOLOGI YANG DIGUNAKAN

Teknologi yang direncanakan:

- Kotlin
- Android Studio
- XML Layout
- Android WebView
- Google ML Kit Barcode Scanning
- Room Database
- Android Keystore
- SoundPool atau MediaPlayer
- ViewBinding
- Gradle Kotlin DSL
- MVVM Architecture

Gunakan versi dependency yang kompatibel dan stabil. Jangan memperbarui dependency secara sembarangan tanpa memeriksa kompatibilitas proyek.

## 4. FITUR UTAMA

### A. Dashboard
- Tampilan utama aplikasi.
- Menu Scan QR.
- Status keamanan.
- Riwayat pelanggaran.
- Pengaturan PIN administrator.
- Tombol uji suara peringatan.

### B. Scan QR
- Membaca QR Code atau barcode berisi tautan ujian.
- Memvalidasi URL.
- Hanya menerima HTTPS.
- Memeriksa domain berdasarkan daftar domain yang diizinkan.
- Menampilkan konfirmasi sebelum membuka ujian.

### C. Secure WebView
- Membuka ujian di dalam aplikasi.
- Mendukung login website.
- Mendukung cookies dan sesi login.
- Mendukung pengisian jawaban dan pengiriman jawaban.
- Memvalidasi navigasi dan pengalihan URL.
- Memblokir popup dan skema URL eksternal yang tidak diizinkan.
- Tidak mengaktifkan akses file lokal yang tidak diperlukan.

### D. Security Manager
- Mengaktifkan FLAG_SECURE.
- Menggunakan screen pinning jika tersedia.
- Mendeteksi sejumlah sinyal perpindahan aplikasi.
- Mencatat aktivitas yang dianggap sebagai indikasi pelanggaran.
- Mencegah pencatatan ganda.
- Menghindari kesimpulan pelanggaran otomatis dari satu sinyal.

### E. Alert Manager
- Satu suara peringatan yang sama untuk semua jenis pelanggaran.
- Suara disimpan secara lokal di aplikasi.
- Durasi suara sekitar 1–2 detik.
- Getaran jika perangkat mendukung.
- Peringatan ditampilkan di aplikasi.
- Setiap kejadian memiliki waktu pencatatan.
- Tidak mengubah volume sistem secara diam-diam.

### F. PIN Administrator
- PIN terdiri dari 6 digit.
- PIN diperlukan untuk mengakhiri sesi ujian melalui aplikasi.
- PIN disimpan dalam bentuk hash dengan salt acak menggunakan PBKDF2.
- Maksimal 5 kali percobaan salah sebelum diberlakukan jeda.
- Mengganti PIN harus menggunakan PIN lama.

### G. Riwayat Pelanggaran
- Menyimpan waktu kejadian.
- Menyimpan jenis kejadian.
- Menyimpan informasi sesi ujian.
- Data disimpan secara lokal menggunakan Room Database.

## 5. BATASAN KEAMANAN

Aplikasi digunakan pada HP Android pribadi siswa (BYOD).

Jangan mengklaim aplikasi dapat mengunci seluruh sistem Android secara mutlak.

Pada perangkat pribadi yang tidak dikelola sebagai Device Owner, aplikasi tidak dapat menjamin pencegahan:
- Force stop.
- Uninstall.
- Restart atau mematikan perangkat.
- Semua bentuk perpindahan aplikasi.
- Semua bentuk perekaman layar.
- Pengambilan gambar menggunakan kamera eksternal.

Screen pinning dan FLAG_SECURE digunakan sebagai perlindungan terbaik sesuai kemampuan Android dan perangkat.

Lock Task Mode penuh hanya digunakan jika perangkat dikonfigurasi sebagai Device Owner.

Pelanggaran dicatat untuk pemeriksaan pengawas. Jangan otomatis membatalkan ujian atau menghapus jawaban siswa.

## 6. STRUKTUR PENGEMBANGAN

Gunakan pemisahan modul sesuai tanggung jawab:

- UI / Presentation
- ViewModel
- Repository
- Data / Room
- QR Scanner
- Secure WebView
- Security Manager
- Alert Manager
- PIN Manager

Sesuaikan struktur folder dengan proyek Android Studio yang benar-benar sudah dibuat. Jangan membuat struktur baru yang merusak file yang sudah ada.

## 7. ATURAN PENGEMBANGAN

1. Repository GitHub Private adalah sumber utama kode aplikasi.
2. Setiap perubahan kode harus disimpan dan di-commit ke GitHub.
3. Jangan menghapus atau menulis ulang kode yang sudah berfungsi tanpa alasan teknis.
4. Sebelum mengubah file, periksa isi dan struktur proyek yang sudah ada.
5. Jangan membuat ulang proyek dari awal setiap kali memulai tahap baru.
6. Gunakan nama package yang konsisten: `id.mtsyatabu.secureexam`.
7. Jangan mengubah teknologi utama tanpa persetujuan.
8. Jangan membuat fitur di luar tujuan Secure Exam Browser tanpa persetujuan.
9. Pastikan aplikasi dapat dikompilasi setelah setiap tahap.
10. Berikan kode lengkap beserta lokasi file dan instruksi pemasangan.
11. Catat setiap perubahan penting pada dokumen ini.
12. Jangan mengarang hasil pengujian. Bedakan fitur yang sudah diuji dan yang belum diuji.

## 8. STATUS PENGEMBANGAN

Status awal proyek:

- [ ] Repository GitHub Private dibuat.
- [ ] Proyek Android Studio dibuat.
- [ ] Dashboard selesai.
- [ ] QR Scanner selesai.
- [ ] URL validation selesai.
- [ ] Secure WebView selesai.
- [ ] Security Manager selesai.
- [ ] Alert Manager selesai.
- [ ] PIN Administrator selesai.
- [ ] Room Database selesai.
- [ ] Integrasi seluruh modul selesai.
- [ ] Pengujian website ujian sebenarnya selesai.
- [ ] APK Debug berhasil dibuat.
- [ ] APK Release berhasil dibuat.

## 9. CATATAN PERKEMBANGAN

Tahap terakhir: Belum dimulai.

Tahap berikutnya: Pembuatan kerangka awal proyek Android.

Tanggal pembaruan: Isi setiap kali dokumen diperbarui.

File penting: Isi berdasarkan struktur proyek aktual.

Dependency penting: Catat versi berdasarkan file Gradle aktual.

Masalah yang belum diselesaikan: Isi berdasarkan hasil pengembangan terakhir.

## 10. INSTRUKSI UNTUK AI PENGEMBANG

Anda bertindak sebagai Android Developer Senior yang melanjutkan proyek Secure Exam Browser MTs Yatabu.

Sebelum menulis kode:

1. Periksa PROJECT_CONTEXT.md.
2. Periksa struktur repository dan file yang sudah tersedia.
3. Identifikasi tahap terakhir yang telah selesai.
4. Periksa kode yang sudah ada.
5. Jangan mengasumsikan fitur sudah selesai jika belum ada bukti implementasi dan pengujian.

Saat mengerjakan tahap baru:

1. Kerjakan hanya tahap yang diminta.
2. Pertahankan kode dan fitur yang sudah berfungsi.
3. Berikan kode lengkap untuk setiap file yang dibuat atau diubah.
4. Sebutkan lokasi file secara tepat.
5. Jelaskan dependency baru jika diperlukan.
6. Berikan langkah pengujian.
7. Laporkan file yang berubah.
8. Perbarui bagian STATUS PENGEMBANGAN dan CATATAN PERKEMBANGAN setelah pekerjaan selesai.

Jika ada informasi yang belum tersedia, tanyakan atau tandai sebagai belum diketahui. Jangan membuat asumsi tentang domain website ujian atau konfigurasi yang belum diberikan.

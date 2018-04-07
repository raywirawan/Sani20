package com.nurina.sani20;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class popUpSanisTipsDialog extends DialogFragment{
    private Button getMoreRandomTips;
    private Button thankyou;
    private ImageButton exitDialog;
    private TextView randomTips;
    public popUpSanisTipsDialog() {

    }

    public static popUpSanisTipsDialog newInstance(){
        return new popUpSanisTipsDialog();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pop_up_tips, container,
                false);
        getDialog().setTitle("DialogFragment Tutorial");
        // Do something else
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getMoreRandomTips= view.findViewById(R.id.getMoreRandomTips);
        randomTips= view.findViewById(R.id.tips);
        randomTips.setText(Tips[getRandomNumber()-1]);
        getMoreRandomTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomTips.setText(Tips[getRandomNumber()-1]);
//                FragmentManager fm = getActivity().getSupportFragmentManager();
//                popUpSanisTipsDialog popUpSanisTipsDialog= com.nurina.sani20.popUpSanisTipsDialog.newInstance();
//                popUpSanisTipsDialog.show(fm,"pop up tips");;]
            }
        });

        thankyou= view.findViewById(R.id.ThankYou);
        thankyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });

        exitDialog=view.findViewById(R.id.exitDialog);
        exitDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {

        super.onResume();
        Window window = getDialog().getWindow();
        Point size = new Point();

        Display display = window.getWindowManager().getDefaultDisplay();

        display.getSize(size);

        window.setLayout((int) (size.x* 1.0),(int)(size.y*0.67));

        window.setGravity(Gravity.BOTTOM);

    }
    private String Tips[] = new String[]{
            "Lakukan pemberantasan hama wereng pada musim hujan dengan menggunakan pestisida",
            "Curah hujan yang tinggi mengakibatkan populasi OPT(Organisme Pengganggu Tanaman). OPT dapat dikendalikan salah satunya dengan penggunaan pestisida sesuai dosis yang dianjurkan ",
            "Penggunaan pestisida harus sesuai dosis yang dianjurkan, agar meminimalisir  pencemaran tanah, air, dan udara",
            "Jangan lupa untuk melakukan pemupukan setiap dua minggu setelah penanaman, dan melakukan penyemprotan satu minggu setelah melakukan pemupukan",
            "Lakukan penyemprotan pada kondisi cuaca cerah, waktu penyemprotan yang tepat pagi hari sebelum jam 09.00 dan sore hari pada jam 15.30.",
            "OPT dapat menjadi kebal apabila padi diberikan pestisida secara terus menerus. Gunakan minimal 3 jenis bahan aktif pestisida yang berbeda serta diaplikasikan secara bergantian",
            "Umur padi pada hari 60-65 hari setelah tanam padi akan mengeluarkan malai/bunga, pada 35-40 hari setelahnya tepat padi berumur 100 hari setelah tanam, padi siap dipanen",
            "Pemberian pupuk 3x dalam satu musim tanam, apabila tanaman sudah hijau maka pemberian pupuk ke 3 tidak perlu menggunakan urea",
            "Dalam 1 Ha tanaman padi kebutuhan pupuk sebagai berikut:\n" +
                    "  Urea 250 Kg/Ha.\n" +
                    "  SP36 100 Kg/Ha.\n" +
                    "  ZA 100 Kg/Ha.\n" +
                    "  NPK 300 Kg/Ha.",
            "Penyemprotan pestisida  menjadi efektif jika penyemprotan dilakukan pada seluruh bagian tanaman. apabila hanya untuk memberikan pupuk atau nutrisi daun, maka bagian daun saja yang harus disemprot",
            "Jangan melakukan penyemprotan padi di atas jam 15.30, karena pada saat itu penyemprotan menjadi tidak efektif disebabkan oleh stoma yang tertutup",
            "Menanam padi dengan menggunakan benih yang bermutu akan memperoleh bibit sehat, cara memilih benih yang baik agar dapat menghasilkan bibit yang sehat, benih direndam dalam larutan ZA 20 gr/liter air, apabila benih tersebut tenggelam maka baik untuk dibudidayakan.",
            "Bibit yang siap dipindahkan dari bedengan persemaian ke petakan sawah ialah yang memiliki daun 5-6 helai, tinggi sekitar 22-25 cm, memiliki batang bawah besar dan keras.",
            "Usia Bibit yang akan dipindahkan dan ditanam ke petakan sawah yaitu pada saat umur 20 hari",
            "Dalam penanaman bibit, kedalaman tanam cukup 2 cm, apabila kurang dari 2 cm bibit mudah hanyut",
            "Jika kondisi tanah yang akan ditaburi bibit masih dalam kondisi tandus, gemburkanlah terlebih dahulu lahan yang akan digunakan tersebut",
            "Padi tidak dapat dilakukan penyemprotan apabila padi tersebut telah memasuki masa penyerbukan, apabila memang diperlukan, penyemprotan dapat dilakukan kembali setelah proses penyerbukan 90% selesai",
            "Pestisida sistemik digunakan untuk mengendalikan OPT yang ada didalam tanaman, seperti uret atau penggerek batang",
            "Pestisida kontak dan lambung digunakan untuk mengendalikan hama dengan mobilitas tinggi, seperti walang sangit atau belalang",
            "Insektisida digunakan untuk mengendalikan hama golongan serangga, seperti walang sangit, ulat, kaper, atau wereng",
            "Fungsida digunakan untuk mengendalikan penyakit tanaman padi yang disebabkan oleh jamur atau cendawan patogen",
            "Dalam melakukan pemupukan pastikan kondisi air sawah dalam keadaan macak-macak.",
            "Pemupukan padi tidak boleh terdapat genangan air, karena dapat menyebabkan pupuk hilang terbawa oleh air.",
            "Benih yang sudah melewati proses seleksi, benih tersebut dibungkus memakai daun pisang dan karung",
            "Ciri-ciri bibit yang baik yaitu berusia 20-40 hari serta memiliki 5-7 helai daun.",
    };

    public int getRandomNumber(){
        double ran = Math.random()*100;
        if (ran > 26 || ran < 1) {
            return getRandomNumber();
        }
        return (int) ran;
    }
}

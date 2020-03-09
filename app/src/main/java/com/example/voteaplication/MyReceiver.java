package com.example.voteaplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SmsBrodadCastReceiver";
    String msg, phoneNo = "";
    daoCandidato daoCandidato;
    daoParticipante daoParticipante;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i(TAG, "Intent Received" + intent.getAction());
        daoCandidato = new daoCandidato(context);
        daoParticipante = new daoParticipante(context);
        if(intent.getAction()==SMS_RECEIVED){
            Bundle dataBundle = intent.getExtras();
            if(dataBundle != null){
                Object[] mypdu = (Object[])dataBundle.get("pdus");
                final SmsMessage[] message = new SmsMessage[mypdu.length];

                for (int i = 0; i<mypdu.length; i++){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        String format = dataBundle.getString("format");
                        message[i] = SmsMessage.createFromPdu((byte[])mypdu[i], format);
                    }else{
                        message[i] = SmsMessage.createFromPdu((byte[]) mypdu[i]);
                    }
                    msg = message[i].getMessageBody();
                    phoneNo = message[i].getOriginatingAddress();
                }
                if(daoParticipante.ifexists(phoneNo)){
                    //Se envía el mensaje.
                }else{
                    if (daoCandidato.ifexists(msg)){
                        daoParticipante.insert_participante(new Participante(phoneNo, msg));
                        daoCandidato.update_votos(msg);
                    }else{
                        //El mensaje del usuario no es válido por lo cual no se registrará dentro del sistema
                    }

                }

                String cadenaMensaje = "Message: " + msg + "\nPhone Number" + phoneNo;
                Toast.makeText(context, cadenaMensaje, Toast.LENGTH_LONG).show();
            }

        }
    }
}

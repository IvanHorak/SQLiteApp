package ivan.tutorial.sqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SQLiteHelper sQLiteHelper = new SQLiteHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void onAddRecord() {
        Intent intent = new Intent(MainActivity.this, TableManipulationActivity.class);
        intent.putExtra(Constants.DML_TYPE,Constants.UPDATE);
        startActivityForResult(intent,Constants.ADD_RECORD);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String firstname = data.getStringExtra(Constants.FIRST_NAME);
            String lastname = data.getStringExtra(Constants.LAST_NAME);


            ContactModel contact = new ContactModel();
            contact.setFirstName(firstname);
            contact.setLastName(lastname);


            if (requestCode == Constants.ADD_RECORD) {
                sQLiteHelper.insertRecord(contact);
            }
        }

    }
}

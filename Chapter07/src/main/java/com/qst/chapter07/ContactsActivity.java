package com.qst.chapter07;

import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Adminstrator on 2016/10/10.
 */
public class ContactsActivity extends AppCompatActivity {
    Button search, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        //获取系统界面中查找、添加两个按钮
        search = (Button) findViewById(R.id.search);
        add = (Button) findViewById(R.id.add);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //定义两个List来疯装系统的联系人信息、指定联系人的电话号码、Email等详情
                final ArrayList<String> names = new ArrayList<String>();
                final ArrayList<ArrayList<String>> details = new ArrayList<>();
                //使用ContentResolver查找联系人数据
                Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                //遍历查询结果或，获取系统中所有联系人
                while (cursor.moveToNext()) {
                    //获取联系人ID
                    String contractId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    //获取联系人的名字
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    names.add(name);
                    //使用ContentResolver查找联系人的电话号码
                    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contractId, null, null);
                    ArrayList<String> detail = new ArrayList<String>();
                    //遍历查询结果，获取该联系人的多个电话号码
                    while (phones.moveToNext()) {
                        //获取查询结果中电话号码列中的数据
                        String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        detail.add("电话号码：" + phoneNumber);
                    }
                    phones.close();
                    //使用ContentResolver查找联系人的E-mail地址
                    Cursor emails = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=" + contractId, null, null);
                    //遍历查询结果，获取该联系人的多个E-mail地址
                    while (emails.moveToNext()) {
                        //获取查询结果中的E-mail地址列中的数据
                        String emailAddress = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        detail.add("邮件地址：" + emailAddress);
                    }
                    emails.close();
                    details.add(detail);
                }
                cursor.close();
                //加载result.xml界面布局代表的视图
                View resultDialog = getLayoutInflater().inflate(R.layout.result, null);
                //获取resultDialog中ID为list的ExpandableListView
                ExpandableListView list = (ExpandableListView) resultDialog.findViewById(R.id.list);
                //创建一个ExpandableListAdapter对象
                ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
                    //获取制定组位置、指定子列表项的子列表项数据
                    @Override
                    public int getGroupCount() {
                        return names.size();
                    }

                    @Override
                    public int getChildrenCount(int groupPosition) {
                        return details.get(groupPosition).size();
                    }
                    private TextView getTextView(){
                        AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                        TextView textView=new TextView(ContactsActivity.this);
                        textView.setLayoutParams(lp);
                        textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                        textView.setPadding(36,0,0,0);
                        textView.setTextSize(15);
                        return textView;
                    }

                    //获取指定组位置处的组数据
                    @Override
                    public Object getGroup(int groupPosition) {
                        return names.get(groupPosition);
                    }

                    @Override
                    public Object getChild(int groupPosition, int childPosition) {
                        return details.get(groupPosition).get(childPosition);
                    }

                    @Override
                    public long getGroupId(int groupPosition) {
                        return groupPosition;
                    }

                    @Override
                    public long getChildId(int groupPosition, int childPosition) {
                        return childPosition;
                    }

                    @Override
                    public boolean hasStableIds() {
                        return true;
                    }

                    //该方法决定每个组选项的外观
                    @Override
                    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                        TextView textView=getTextView();
                        textView.setText(getGroup(groupPosition).toString());
                        return textView;
                    }
                    //该方法据顶每个子选项的外观
                    @Override
                    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                        TextView textView=getTextView();
                        textView.setText(getChild(groupPosition, childPosition).toString());
                        return textView;
                    }

                    @Override
                    public boolean isChildSelectable(int groupPosition, int childPosition) {
                        return true;
                    }
                };
                //为ExpandListView设置Adapter对象
                list.setAdapter(adapter);
                //使用对话框来显示查询结果
                new AlertDialog.Builder(ContactsActivity.this).setView(resultDialog).setPositiveButton("确定",null).show();
            }
        });
        //为add按钮的单击事件帮点监听器
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取程序界面中的三个文本框的内容
                String name=((EditText)findViewById(R.id.name)).getText().toString();
                String phone=((EditText)findViewById(R.id.phone)).getText().toString();
                String email=((EditText)findViewById(R.id.email)).getText().toString();
                //创建一个空的ContentValues
                ContentValues values=new ContentValues();
                //向RawContacts.CONTENT_URI执行一个空值插入。目的是获取系统返回的rawContactId
                Uri rawContactUri=getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI,values);
                long rawContactId= ContentUris.parseId(rawContactUri);
                values.clear();
                values.put(ContactsContract.Contacts.Data.RAW_CONTACT_ID,rawContactId);
                //设置内容类型
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                //设置联系人名字
                values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,name);
                //向联系人URI添加联系人名字
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI,values);
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID,rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                //设置联系人的电话号码
                values.put(ContactsContract.CommonDataKinds.Phone.NUMBER,phone);
                //设置电话类型
                values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                //向联系人电话号码URI添加电话号码
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI,values);
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID,rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE);
                //设置联系人的E-mail地址
                values.put(ContactsContract.CommonDataKinds.Email.DATA,email);
                //设置该电子邮件的类型
                values.put(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK);
                //向联系人E-mail URI添加E-mail数据
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI,values);
                Toast.makeText(ContactsActivity.this,"联系人数据添加成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

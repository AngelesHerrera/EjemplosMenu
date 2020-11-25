package com.example.ejemplosmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.PopupMenu

class MainActivity : AppCompatActivity() ,PopupMenu.OnMenuItemClickListener{

    private var actionMode: ActionMode? = null;
    var popupMenu: PopupMenu?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton1: Button= findViewById(R.id.button)
        val boton2: Button= findViewById(R.id.button2)
        registerForContextMenu(boton1)

        boton2.setOnLongClickListener{
                view -> when (actionMode) {
                null->{
                actionMode= this.startActionMode(actionModeCallback)
                view.isSelected= true
                true
            }
            else-> false
        }
        }
    }
    fun mostrarMenu(v: View){
    if(popupMenu==null){
        popupMenu= PopupMenu(this,v)
        val inflater: MenuInflater= popupMenu!!.menuInflater
        inflater.inflate(R.menu.menu_popup,popupMenu!!.menu)
        popupMenu!!.setOnMenuItemClickListener (this)
    }
        popupMenu!!.show()
    }
    override fun onContextItemSelected(item: MenuItem): Boolean = when (item.itemId){
        R.id.m_contextual_op1->{
            Log.e("MENUCONTEXT","se presiono 1")
            true
        }
        R.id.m_contextual_op2->{
            Log.e("MENUCONTEXT","se presiono 2")
            true
        }
        R.id.m_contextual_op3->{
            Log.e("MENUCONTEXT","se presiono 3")
            true
        }
       else-> super.onContextItemSelected(item)
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        val inflater: MenuInflater= menuInflater
        inflater.inflate(R.menu.menu_contextual,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    private val actionModeCallback = object: ActionMode.Callback{
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean =
            when(item.itemId){
                R.id.m_action_op1->{
                    Log.e("MenuAction","presiono 1")
                    true
                }
                R.id.m_action_op2->{
                    Log.e("MenuAction","presiono 2")
                    true
                }
                R.id.m_action_op3->{
                    Log.e("MenuAction","presiono 3")
                    true
                }

                else-> false
            }

        override fun onCreateActionMode(mode: ActionMode, menu: Menu?): Boolean {
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.menu_action, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean = false

        override fun onDestroyActionMode(mode: ActionMode?) {
           actionMode= null
        }

    }

    override fun onMenuItemClick(item: MenuItem): Boolean =
        when(item.itemId){
            R.id.menu_popup_op1->{
                item.isChecked= !item.isChecked
                Log.e("MenuPopup","Se Presiono 1")
                true
            }
            R.id.menu_popup_op2->{
                item.isChecked= !item.isChecked
                Log.e("MenuPopup","Se Presiono 2")
                true
            }
            else-> false
        }

    }

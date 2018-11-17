package com.scrumbusters.hack2progress.Views;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import com.scrumbusters.hack2progress.R;

import android.view.MenuItem;


/*
------------------------------------------------------------------
    Vista principal

    Presenta los datos de las gasolineras en formato lista.


------------------------------------------------------------------
*/
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Dialogo para mostrar el progreso de obtencion de datos de las gasolineras

    /**
     * onCreate
     * <p>
     * Crea los elementos que conforman la actividad
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se carga el content view
        setContentView(R.layout.activity_navigation);



        //Se Carga el toolbar
        Toolbar toolbar =  findViewById(R.id.toolbar);
        
        setSupportActionBar(toolbar);
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Se anhade listener al menu desplegable
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MyPagerAdapter myPagerAdapter =
                new MyPagerAdapter(
                        getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }





        /**
     * Define las distintas respuestas del menu de navegacion
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.idNavGrupos) {
           // filtrarCombustible();

        } else if (id == R.id.idEstadisticas) {
            //mostrarGasolinerasProvincia();
        }else if(id==R.id.idNavPerfiles){

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment;
            switch(i) {
                case 0:
                    fragment = new DashBoardFragment();
                    break;
                case 1:
                    fragment = new GruposFragment();
                    break;
                default:
                    fragment = null;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "DashBoard";
                case 1:
                    return "Grupos";
            }
            return null;
        }


    }

}


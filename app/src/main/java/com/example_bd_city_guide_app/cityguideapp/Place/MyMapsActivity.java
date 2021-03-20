package com.example_bd_city_guide_app.cityguideapp.Place;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example_bd_city_guide_app.cityguideapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyMapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    private List<Marker> markerListBoat;
    private List<Marker> markerListBus;
    private List<Marker> markerListDhaka;
    private List<Marker> markerListMymensingh;
    private List<Marker> markerListKhulna;
    private List<Marker> markerListRajshahi;
    private List<Marker> markerListBarishal;
    private List<Marker> markerListRangpur;
    private List<Marker> markerListChittagong;
    private List<Marker> markerListSylhet;


    private CardView fav;
    private FusedLocationProviderClient mLocations;

    private EditText searchET;
    private ImageView searchIV;

    Intent intent;
    String locName;
    private String msg;
    private String address;
    private String tourCategories;

    private Marker bangladesh_Eco_Adventure, dhaka_River_Cruise, rocket_Steamer_Boat_Station, viking_Marina, the_Bengal_Tours_Ltd, sundarban_Tour_Operators,
            sundarban_boat_tour_agent, boiddar_Bazar_Boat_Terminal, royal_Bengal_Tours, sundarban_Tour, bangladesh_Scenic_Tours, ever_Green_Tours, trip_to_the_Chittagong_hill_tracts,
            high_Speed_Boat_Stand, bangladesh_tours, naria_Speed_Boat_Ghat, boat_of_Sindbad, sundarban_Ac_boat_in_khulna;

    private Marker sRatargulGuainghatSylhet, sLalakhal, sTanguarHaor, sSreemongolAround, sBisnakandi, sJaflong, sLuvachora;
    private LatLng _sRatargulGuainghatSylhet, _sLalakhal, _sTanguarHaor, _sSreemongolAround, _sBisnakandi, _sJaflong, _sLuvachora;

    private Marker mMusium, mhasanManjil, mShashiLodge, mZaynalAbedin, mAlexanderCastle, mMoynaDeep, mBirishiri, mMuktagachaRajbari;
    private LatLng _mMusium, _mhasanManjil, _mShashiLodge, _mZaynalAbedin, _mAlexanderCastle, _mMoynaDeep, _mBirishiri, _mMuktagachaRajbari;

    private Marker bKuakataSeaBeach, bSonarChar, bGuavaMarket, bGuthiaMosque, bFatrarChar, bDurgasagar, bLeburChar, bKuakataBuddhistTemple;
    private LatLng _bKuakataSeaBeach, _bSonarChar, _bGuavaMarket, _bGuthiaMosque, _bFatrarChar, _bDurgasagar, _bLeburChar, _bKuakataBuddhistTemple;

    private Marker dLalbaghFort, dAhsanManzilMuseum, dBangladeshNationalParliament, dBangladeshNationalZoo, dNationalMartyrs, dBhawalRajbari, dSafariPark, dTangailDCLake, dAtiyaJameMosque, dIshaKhanJangalbariFort, dAustagramHaor, dChandrabatiMandir, dNikliBeribadh;
    private LatLng _dLalbaghFort, _dAhsanManzilMuseum, _dBangladeshNationalParliament, _dBangladeshNationalZoo, _dNationalMartyrs, _dBhawalRajbari, _dSafariPark, _dTangailDCLake, _dAtiyaJameMosque, _dIshaKhanJangalbariFort, _dAustagramHaor, _dChandrabatiMandir, _dNikliBeribadh;


    private Marker rTajhatPalace, rTownHall, rMithapukurBaraMosque, rBegumRokeyaMemorial, rKellabandMosqueMasjid, rItakumariJamindarBari, rManthanaZamindarBari;
    private LatLng _rTajhatPalace, _rTownHall, _rMithapukurBaraMosque, _rBegumRokeyaMemorial, _rKellabandMosqueMasjid, _rItakumariJamindarBari, _rManthanaZamindarBari;

    private Marker cCoxBazarBeach, cBogaLake, cNilgiriMountains, cSaintMartinIsland, cPatengaBeach, cHimchori, cShalbanBihar, cSajek;
    private LatLng _cCoxBazarBeach, _cBogaLake, _cNilgiriMountains, _cSaintMartinIsland, _cPatengaBeach, _cHimchori, _cShalbanBihar, _cSajek;

    private Marker rBijoySagar, rShahidMinar, rPadmaGarden, rVarendraResearchMuseum, rBaghaShahiMasjid, rBoroKuthi, rPuthiaRajbariComplex;
    private LatLng _rBijoySagar, _rShahidMinar, _rPadmaGarden, _rVarendraResearchMuseum, _rBaghaShahiMasjid, _rBoroKuthi, _rPuthiaRajbariComplex;

    private Marker kSundarbanNationalPark, kSajnekhali, kHironPointBangladesh, kSudhanyakhaliWatchTower, kDobankiWatchTower, kJamtolaBeach, kDobankiCamp;
    private LatLng _kSundarbanNationalPark, _kSajnekhali, _kHironPointBangladesh, _kSudhanyakhaliWatchTower, _kDobankiWatchTower, _kJamtolaBeach, _kDobankiCamp;

    private Marker tSB, tMB, hTB, rCT, nT, mHB, bST, bTH, tATB, vT;
    private int GPS_REQUEST_CODE = 9001;
    private Boolean globalProvider;
    private Boolean isCheckPermission = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_maps);

        init();
        checkPermission();
        initMap();

        tourCategories = getIntent().getStringExtra("tourCategories");
        msg = getIntent().getStringExtra("msg");
        address = getIntent().getStringExtra("address");


    }

    private void geoLocate(View view) {


        locName = searchET.getText().toString();
        searchET.setText("");
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocationName(locName, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);

                String placeName = address.getFeatureName() + "," + address.getSubAdminArea() + "," + address.getAdminArea() + "," + address.getCountryName();
                gotoLocation(address.getLatitude(), address.getLongitude(), placeName, address.getFeatureName());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getDescriptionsAddress() {

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocationName(address, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);

                String placeName = address.getFeatureName() + "," + address.getSubAdminArea() + "," + address.getAdminArea() + "," + address.getCountryName();

               gotoLocation(address.getLatitude(),address.getLongitude(),placeName,address.getFeatureName());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void getCurrentLocations() {
        checkPermission();
        mLocations.getLastLocation().addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                Location location = task.getResult();

                if (location == null) {

                    Toast.makeText(this, "Sorry! No Locations found!", Toast.LENGTH_SHORT).show();
                } else {
                    getUserAddress(location.getLatitude(), location.getLongitude());

                }


            }

        });

    }

    private void getUserAddress(double latitude, double longitude) {

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);

                String placeName = address.getFeatureName() + "," + address.getSubAdminArea() + "," + address.getAdminArea() + "," + address.getCountryName();

                gotoLocation(address.getLatitude(), address.getLongitude(), placeName, address.getFeatureName());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void gotoLocation(double latitude, double longitude, String placeName, String locName) {

        LatLng latLng = new LatLng(latitude, longitude);

        Marker marker = mMap.addMarker(new MarkerOptions().title(locName).snippet(placeName).position(latLng));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 12);
        mMap.moveCamera(cameraUpdate);

        Toast.makeText(this, "" + placeName, Toast.LENGTH_SHORT).show();

    }

    private void initMap() {

        if (gpsEnable()) {
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

    }

    private boolean gpsEnable() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        Boolean providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        globalProvider = providerEnable;
        if (providerEnable) {
            return true;
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle(" GPS Permissions")
                    .setMessage("GPS is required for this app to work. Please Enable GPS!")
                    .setPositiveButton("Yes", ((dialogInterface, i) -> {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, GPS_REQUEST_CODE);
                    }))
                    .setCancelable(false)
                    .show();

        }
        return false;
    }

    private void showDhakaAll() {

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Marker dLalbaghFort, dAhsanManzilMuseum, dBangladeshNationalParliament, dBangladeshNationalZoo, dNationalMartyrs, dBhawalRajbari, dSafariPark, dTangailDCLake, dAtiyaJameMosque, dIshaKhanJangalbariFort, dAustagramHaor, dChandrabatiMandir, dNikliBeribadh;
        LatLng _dLalbaghFort, _dAhsanManzilMuseum, _dBangladeshNationalParliament, _dBangladeshNationalZoo, _dNationalMartyrs, _dBhawalRajbari, _dSafariPark, _dTangailDCLake, _dAtiyaJameMosque, _dIshaKhanJangalbariFort, _dAustagramHaor, _dChandrabatiMandir, _dNikliBeribadh;

        _dLalbaghFort = new LatLng(23.7188654, 90.3859709);
        _dAhsanManzilMuseum = new LatLng(23.7085964, 90.4038187);
        _dBangladeshNationalParliament = new LatLng(23.7624709, 90.3763924);
        _dBangladeshNationalZoo = new LatLng(23.8122314, 90.3447513);
        _dNationalMartyrs = new LatLng(23.911269, 90.2525913);
        _dBhawalRajbari = new LatLng(24.0006834, 90.4232361);
        _dSafariPark = new LatLng(24.1699598, 90.3943501);
        _dTangailDCLake = new LatLng(24.2651609, 89.9208906);
        _dAtiyaJameMosque = new LatLng(24.184085, 89.9092079);
        _dIshaKhanJangalbariFort = new LatLng(24.450535, 90.8397309);
        _dAustagramHaor = new LatLng(24.3210947, 90.8918538);
        _dNikliBeribadh = new LatLng(24.3266057, 90.9171865);
        _dChandrabatiMandir = new LatLng(24.4956276, 90.7987404);


        dLalbaghFort = mMap.addMarker(new MarkerOptions().position(_dLalbaghFort).title("Lalbagh Fort").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        dAhsanManzilMuseum = mMap.addMarker(new MarkerOptions().position(_dAhsanManzilMuseum).title("Ahsan Manzil Museum").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        dBangladeshNationalParliament = mMap.addMarker(new MarkerOptions().position(_dBangladeshNationalParliament).title("Bangladesh National Parliament").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        dBangladeshNationalZoo = mMap.addMarker(new MarkerOptions().position(_dBangladeshNationalZoo).title("Bangladesh National Zoo, Mirpur").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        dNationalMartyrs = mMap.addMarker(new MarkerOptions().position(_dNationalMartyrs).title("জাতীয় স্মৃতিসৌধ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        dBhawalRajbari = mMap.addMarker(new MarkerOptions().position(_dBhawalRajbari).title("Bhawal Rajbari").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        dSafariPark = mMap.addMarker(new MarkerOptions().position(_dSafariPark).title("Bangabandhu Sheikh Mujib Safari Park, Gazipur").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dTangailDCLake = mMap.addMarker(new MarkerOptions().position(_dTangailDCLake).title("Tangail DC Lake").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dAtiyaJameMosque = mMap.addMarker(new MarkerOptions().position(_dAtiyaJameMosque).title("Atiya Jame Mosque").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dIshaKhanJangalbariFort = mMap.addMarker(new MarkerOptions().position(_dIshaKhanJangalbariFort).title("Isha Khan's Jangalbari Fort").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dAustagramHaor = mMap.addMarker(new MarkerOptions().position(_dAustagramHaor).title("Austagram Haor").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dNikliBeribadh = mMap.addMarker(new MarkerOptions().position(_dNikliBeribadh).title("Nikli Beribadh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dChandrabatiMandir = mMap.addMarker(new MarkerOptions().position(_dChandrabatiMandir).title("Chandrabati Mandir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListDhaka.add(dLalbaghFort);
        markerListDhaka.add(dAhsanManzilMuseum);
        markerListDhaka.add(dBangladeshNationalParliament);
        markerListDhaka.add(dBangladeshNationalZoo);
        markerListDhaka.add(dNationalMartyrs);
        markerListDhaka.add(dBhawalRajbari);
        markerListDhaka.add(dSafariPark);
        markerListDhaka.add(dTangailDCLake);
        markerListDhaka.add(dAtiyaJameMosque);
        markerListDhaka.add(dIshaKhanJangalbariFort);
        markerListDhaka.add(dAustagramHaor);
        markerListDhaka.add(dChandrabatiMandir);
        for (Marker marker : markerListDhaka) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();
                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Lalbagh Fort")) {
                    mapDialog(markerTitle, "+88029673018", "Lalbagh Rd, Dhaka 1211", "http://www.archaeology.gov.bd/");

                } else if (markerTitle.equals("Ahsan Manzil Museum")) {
                    mapDialog(markerTitle, "+880257391122", "Latif Complex, ইসলামপুর রোড, ঢাকা", "No Website found!");
                } else if (markerTitle.equals("Bangladesh National Parliament")) {
                    mapDialog(markerTitle, "+880255028840", "Dhaka 1207", "http://www.parliament.gov.bd/");
                } else if (markerTitle.equals("Bangladesh National Zoo, Mirpur")) {
                    mapDialog(markerTitle, "+880258053030", "চিড়িয়াখানা রোড, ঢাকা 1216", "http://bnzoo.org/");
                } else if (markerTitle.equals("জাতীয় স্মৃতিসৌধ")) {
                    mapDialog(markerTitle, "No Phone Number found!", "Dhaka - Aricha Hwy, সাভার ইউনিয়ন 1344", "No Website Found!");
                } else if (markerTitle.equals("Bhawal Rajbari")) {
                    mapDialog(markerTitle, "No Phone Number found!", "A/132 Bazar Rd, Gazipur 1700", "No Website Found!");
                } else if (markerTitle.equals("Bangabandhu Sheikh Mujib Safari Park, Gazipur")) {
                    mapDialog(markerTitle, "+8801842434401", "1340 Safari Park Rd, শ্রীপুর", "http://www.safariparkgazipur.info.bd/");
                } else if (markerTitle.equals("Tangail DC Lake")) {
                    mapDialog(markerTitle, "+8801882429591", "টাঙ্গাইল", "No Website Found!");
                } else if (markerTitle.equals("Atiya Jame Mosque")) {
                    mapDialog(markerTitle, "No Phone Number found!", "টাঙ্গাইল", "No Website Found!");
                } else if (markerTitle.equals("Isha Khan's Jangalbari Fort")) {
                    mapDialog(markerTitle, "No Phone Number found!", "জঙ্গলবাড়ী,করিমগঞ্জ উপজেলা,কিশোরগঞ্জ.", "No Website Found!");
                } else if (markerTitle.equals("Austagram Haor")) {
                    mapDialog(markerTitle, "No Phone Number found!", "অষ্টগ্রাম হাওর, কিশোরগঞ্জ", "http://www.facebook.com/ExploreHaor");
                } else if (markerTitle.equals("Nikli Beribadh")) {
                    mapDialog(markerTitle, "No Phone Number found!", "Unnamed Road, নিকলি", "No Website Found!");
                } else if (markerTitle.equals("Chandrabati Mandir")) {
                    mapDialog(markerTitle, "No Phone Number found!", "কিশোরগঞ্জ - তারাইল রোড", "No Website Found!");
                }


                return false;
            }
        });
    }

    private void showMymensinghAll() {
        Marker mMusium, mhasanManjil, mShashiLodge, mZaynalAbedin, mAlexanderCastle, mMoynaDeep, mBirishiri, mMuktagachaRajbari;
        LatLng _mMusium, _mhasanManjil, _mShashiLodge, _mZaynalAbedin, _mAlexanderCastle, _mMoynaDeep, _mBirishiri, _mMuktagachaRajbari;

        _mMusium = new LatLng(24.7607552, 90.1253969);
        _mhasanManjil = new LatLng(24.7611197, 90.4051734);
        _mShashiLodge = new LatLng(24.7617618, 90.4008346);
        _mZaynalAbedin = new LatLng(24.6583369, 90.40593);
        _mAlexanderCastle = new LatLng(24.7657479, 90.3998389);
        _mMoynaDeep = new LatLng(24.7130507, 90.4561053);
        _mBirishiri = new LatLng(25.1050596, 90.6621301);
        _mMuktagachaRajbari = new LatLng(24.6643676, 90.1960377);


        mMusium = mMap.addMarker(new MarkerOptions().position(_mMusium).title("Mymensingh Museum").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        mhasanManjil = mMap.addMarker(new MarkerOptions().position(_mhasanManjil).title("Hasan Monzil").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        mShashiLodge = mMap.addMarker(new MarkerOptions().position(_mShashiLodge).title("Shashi Lodge").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        mZaynalAbedin = mMap.addMarker(new MarkerOptions().position(_mZaynalAbedin).title("শিল্পাচার্য জয়নুল আবেদিন সংগ্রহশালা").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        mAlexanderCastle = mMap.addMarker(new MarkerOptions().position(_mAlexanderCastle).title("Alexander Castle").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        mMoynaDeep = mMap.addMarker(new MarkerOptions().position(_mMoynaDeep).title("Moyna Deep").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        mBirishiri = mMap.addMarker(new MarkerOptions().position(_mBirishiri).title("Birirshiri").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        mMuktagachaRajbari = mMap.addMarker(new MarkerOptions().position(_mMuktagachaRajbari).title("মুক্তাগাছা জমিদার বাড়ি").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).alpha(0.8f));

        markerListMymensingh.add(mMusium);
        markerListMymensingh.add(mhasanManjil);
        markerListMymensingh.add(mShashiLodge);
        markerListMymensingh.add(mZaynalAbedin);
        markerListMymensingh.add(mAlexanderCastle);
        markerListMymensingh.add(mMoynaDeep);
        markerListMymensingh.add(mBirishiri);
        markerListMymensingh.add(mMuktagachaRajbari);
        for (Marker marker : markerListMymensingh) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();

                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Mymensingh Museum")) {
                    mapDialog(markerTitle, "+8801758538909", "ময়মনসিংহ", "http://www.mymensingh.gov.bd/");

                } else if (markerTitle.equals("Hasan Monzil")) {
                    mapDialog(markerTitle, "+8801768570119", "ঈশাণ চক্রবর্ত্তী রোড, ময়মনসিংহ", "No website found!");
                } else if (markerTitle.equals("Shashi Lodge")) {
                    mapDialog(markerTitle, "+8801910610330", "Teachers Training Collage (women, কাচারী রোড, ময়মনসিংহ", "No website found!");
                } else if (markerTitle.equals("শিল্পাচার্য জয়নুল আবেদিন সংগ্রহশালা")) {
                    mapDialog(markerTitle, "+8809166960", "Park Road, Mymensingh", "https://zainulsangrahashala.org.bd/");
                } else if (markerTitle.equals("Alexander Castle")) {
                    mapDialog(markerTitle, "No phone found!", "Mymensingh", "No website found!");
                } else if (markerTitle.equals("Moyna Deep")) {
                    mapDialog(markerTitle, "No phone found!", "Charnilakshia Batipara,Mymensingh", "No website found!");
                } else if (markerTitle.equals("Birirshiri")) {
                    mapDialog(markerTitle, "No phone found!", "Birishiri, Durgapur", "No website found!");
                } else if (markerTitle.equals("মুক্তাগাছা জমিদার বাড়ি")) {
                    mapDialog(markerTitle, "+8801627651952", "College Rd, মুক্তাগাছা 2210", "https://muktagachha-jomidar-bari.business.site/?utm_source=gmb&utm_medium=referral");
                }


                return false;
            }
        });


    }

    private void showBarishalAll() {


        _bKuakataSeaBeach = new LatLng(21.8158454, 90.1179308);
        _bSonarChar = new LatLng(21.837258, 90.486059);
        _bGuavaMarket = new LatLng(22.7337815, 90.1482268);
        _bGuthiaMosque = new LatLng(22.7029366, 90.3444095);
        _bFatrarChar = new LatLng(21.8664743, 90.0751627);
        _bDurgasagar = new LatLng(22.760991, 90.2873182);
        _bLeburChar = new LatLng(21.8428104, 90.0855411);


        bKuakataSeaBeach = mMap.addMarker(new MarkerOptions().position(_bKuakataSeaBeach).title("Kuakata Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        bSonarChar = mMap.addMarker(new MarkerOptions().position(_bSonarChar).title("Sonar char").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        bGuavaMarket = mMap.addMarker(new MarkerOptions().position(_bGuavaMarket).title("Guava Market").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        bGuthiaMosque = mMap.addMarker(new MarkerOptions().position(_bGuthiaMosque).title("Guthia Mosque").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        bFatrarChar = mMap.addMarker(new MarkerOptions().position(_bFatrarChar).title("Fatrar Char").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        bDurgasagar = mMap.addMarker(new MarkerOptions().position(_bDurgasagar).title("Durga Sagar").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        bLeburChar = mMap.addMarker(new MarkerOptions().position(_bLeburChar).title("Lebur Char").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListBarishal.add(bKuakataSeaBeach);
        markerListBarishal.add(bSonarChar);
        markerListBarishal.add(bGuavaMarket);
        markerListBarishal.add(bGuthiaMosque);
        markerListBarishal.add(bFatrarChar);
        markerListBarishal.add(bDurgasagar);
        markerListBarishal.add(bLeburChar);
        for (Marker marker : markerListBarishal) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();

                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Kuakata Beach")) {
                    mapDialog(markerTitle, "", "Kuakata,Barishal", "");

                } else if (markerTitle.equals("Sonar char")) {
                    mapDialog(markerTitle, "", "Sonar Char,Barishal", "");
                } else if (markerTitle.equals("Guava Market")) {
                    mapDialog(markerTitle, "", "আটঘর - নবগ্রাম রোড, আটঘর কুড়িয়ানা ইউনিয়ন", "");
                } else if (markerTitle.equals("Guthia Mosque")) {
                    mapDialog(markerTitle, "", "Barishal", "");
                } else if (markerTitle.equals("Fatrar Char")) {
                    mapDialog(markerTitle, "", "Barishal", "");
                } else if (markerTitle.equals("Durga Sagar")) {
                    mapDialog(markerTitle, "", "8213 স্বরুপকাঠি - বরিশাল রোড, মাধবপাশা", "");
                } else if (markerTitle.equals("Lebur Char")) {
                    mapDialog(markerTitle, "", "Barishal", "");
                }


                return false;
            }
        });

    }

    private void showRajshahiAll() {


        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Marker rBijoySagar, rShahidMinar, rPadmaGarden, rVarendraResearchMuseum, rBaghaShahiMasjid, rBoroKuthi, rPuthiaRajbariComplex;
        LatLng _rBijoySagar, _rShahidMinar, _rPadmaGarden, _rVarendraResearchMuseum, _rBaghaShahiMasjid, _rBoroKuthi, _rPuthiaRajbariComplex;

        _rBijoySagar = new LatLng(24.3731541, 88.6469974);
        _rShahidMinar = new LatLng(24.3682765, 88.6372983);
        _rPadmaGarden = new LatLng(24.3615844, 88.5949244);
        _rVarendraResearchMuseum = new LatLng(24.3670577, 88.5903295);
        _rBaghaShahiMasjid = new LatLng(24.1959114, 88.8372124);
        _rBoroKuthi = new LatLng(24.3621093, 88.5959846);
        _rPuthiaRajbariComplex = new LatLng(24.3618971, 88.8345278);


        rBijoySagar = mMap.addMarker(new MarkerOptions().position(_rBijoySagar).title("Bijoy Sagar, Rajshahi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        rShahidMinar = mMap.addMarker(new MarkerOptions().position(_rShahidMinar).title("Shahid Minar, Rajshahir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        rPadmaGarden = mMap.addMarker(new MarkerOptions().position(_rPadmaGarden).title("Padma Garden").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rVarendraResearchMuseum = mMap.addMarker(new MarkerOptions().position(_rVarendraResearchMuseum).title("Varendra Research Museum").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rBaghaShahiMasjid = mMap.addMarker(new MarkerOptions().position(_rBaghaShahiMasjid).title("Bagha Shahi Masjid").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        rBoroKuthi = mMap.addMarker(new MarkerOptions().position(_rBoroKuthi).title("Boro Kuthi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        rPuthiaRajbariComplex = mMap.addMarker(new MarkerOptions().position(_rPuthiaRajbariComplex).title("Puthia Rajbari Complex").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListRajshahi.add(rBijoySagar);
        markerListRajshahi.add(rShahidMinar);
        markerListRajshahi.add(rPadmaGarden);
        markerListRajshahi.add(rVarendraResearchMuseum);
        markerListRajshahi.add(rBaghaShahiMasjid);
        markerListRajshahi.add(rBoroKuthi);
        markerListRajshahi.add(rPuthiaRajbariComplex);
        for (Marker marker : markerListRajshahi) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();

                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Bijoy Sagar, Rajshahi")) {
                    mapDialog(markerTitle, "", "Rajshahi", "");

                } else if (markerTitle.equals("Shahid Minar, Rajshahir")) {
                    mapDialog(markerTitle, "", "Rajshahi", "");
                } else if (markerTitle.equals("Padma Garden")) {
                    mapDialog(markerTitle, "", "Dorgapara Rajshahi College Pathway, Rajshahi", "");
                } else if (markerTitle.equals("Varendra Research Museum")) {
                    mapDialog(markerTitle, "+8801763002204", "রাজশাহী", "http://ru.ac.bd/");
                } else if (markerTitle.equals("Bagha Shahi Masjid")) {
                    mapDialog(markerTitle, "", "বাঘা,রাজশাহী", "");
                } else if (markerTitle.equals("Boro Kuthi")) {
                    mapDialog(markerTitle, "", "রাজশাহী", "");
                } else if (markerTitle.equals("Puthia Rajbari Complex")) {
                    mapDialog(markerTitle, "", "রাজশাহী", "");
                }


                return false;
            }
        });
    }

    private void showKhulnaAll() {

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Marker kSundarbanNationalPark, kSajnekhali, kHironPointBangladesh, kSudhanyakhaliWatchTower, kDobankiWatchTower, kJamtolaBeach, kDobankiCamp;
        LatLng _kSundarbanNationalPark, _kSajnekhali, _kHironPointBangladesh, _kSudhanyakhaliWatchTower, _kDobankiWatchTower, _kJamtolaBeach, _kDobankiCamp;

        _kSundarbanNationalPark = new LatLng(24.3731541, 88.6469974);
        _kSajnekhali = new LatLng(24.3682765, 88.6372983);
        _kHironPointBangladesh = new LatLng(24.3615844, 88.5949244);
        _kSudhanyakhaliWatchTower = new LatLng(24.3670577, 88.5903295);
        _kDobankiWatchTower = new LatLng(24.1959114, 88.8372124);
        _kJamtolaBeach = new LatLng(24.3621093, 88.5959846);
        _kDobankiCamp = new LatLng(24.3618971, 88.8345278);


        kSundarbanNationalPark = mMap.addMarker(new MarkerOptions().position(_kSundarbanNationalPark).title("Sundarban National Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        kSajnekhali = mMap.addMarker(new MarkerOptions().position(_kSajnekhali).title("Sajne khali").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        kHironPointBangladesh = mMap.addMarker(new MarkerOptions().position(_kHironPointBangladesh).title("Hiron Point Bangladesh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        kSudhanyakhaliWatchTower = mMap.addMarker(new MarkerOptions().position(_kSudhanyakhaliWatchTower).title("Sudhanya khali Watch Tower").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        kDobankiWatchTower = mMap.addMarker(new MarkerOptions().position(_kDobankiWatchTower).title("Dobanki Watch Tower").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        kJamtolaBeach = mMap.addMarker(new MarkerOptions().position(_kJamtolaBeach).title("Jamtola Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        kDobankiCamp = mMap.addMarker(new MarkerOptions().position(_kDobankiCamp).title("Dobanki Camp").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListKhulna.add(kSundarbanNationalPark);
        markerListKhulna.add(kSajnekhali);
        markerListKhulna.add(kHironPointBangladesh);
        markerListKhulna.add(kSudhanyakhaliWatchTower);
        markerListKhulna.add(kDobankiWatchTower);
        markerListKhulna.add(kJamtolaBeach);
        markerListKhulna.add(kDobankiCamp);
        for (Marker marker : markerListKhulna) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();

                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Sundarban National Park")) {
                    mapDialog(markerTitle, "+8801915007769", "Mongla,Khulna", "");

                } else if (markerTitle.equals("Sajne khali")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                } else if (markerTitle.equals("Hiron Point Bangladesh")) {
                    mapDialog(markerTitle, "", "Khulna", "");
                } else if (markerTitle.equals("Sudhanya khali Watch Tower")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                } else if (markerTitle.equals("Dobanki Watch Tower")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                } else if (markerTitle.equals("Jamtola Beach")) {
                    mapDialog(markerTitle, "", "Khulna", "");
                } else if (markerTitle.equals("Dobanki Camp")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                }


                return false;
            }
        });

    }

    private void showChittagoAngAll() {

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Marker cCoxBazarBeach, cBogaLake, cNilgiriMountains, cSaintMartinIsland, cPatengaBeach, cHimchori, cShalbanBihar, cSajek;
        LatLng _cCoxBazarBeach, _cBogaLake, _cNilgiriMountains, _cSaintMartinIsland, _cPatengaBeach, _cHimchori, _cShalbanBihar, _cSajek;

        _cCoxBazarBeach = new LatLng(21.4285152, 91.9614311);
        _cBogaLake = new LatLng(21.9803442, 92.4675491);
        _cNilgiriMountains = new LatLng(21.911878, 92.3232463);
        _cSaintMartinIsland = new LatLng(20.6059155, 92.2919519);
        _cPatengaBeach = new LatLng(22.2359895, 91.7868103);
        _cHimchori = new LatLng(21.3548955, 92.0240666);
        _cShalbanBihar = new LatLng(23.4262578, 91.1355817);
        _cSajek = new LatLng(23.3814161, 92.2861862);


        cCoxBazarBeach = mMap.addMarker(new MarkerOptions().position(_cCoxBazarBeach).title("Cox's Bazar Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        cBogaLake = mMap.addMarker(new MarkerOptions().position(_cBogaLake).title("Boga Lake").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        cNilgiriMountains = mMap.addMarker(new MarkerOptions().position(_cNilgiriMountains).title("Nilgiri Mountains").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        cSaintMartinIsland = mMap.addMarker(new MarkerOptions().position(_cSaintMartinIsland).title("Saint Martin Island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        cPatengaBeach = mMap.addMarker(new MarkerOptions().position(_cPatengaBeach).title("Patenga Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        cHimchori = mMap.addMarker(new MarkerOptions().position(_cHimchori).title("Himchori").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        cShalbanBihar = mMap.addMarker(new MarkerOptions().position(_cShalbanBihar).title("Shalban Bihar").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        cSajek = mMap.addMarker(new MarkerOptions().position(_cSajek).title("Sajek").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListChittagong.add(cCoxBazarBeach);
        markerListChittagong.add(cBogaLake);
        markerListChittagong.add(cNilgiriMountains);
        markerListChittagong.add(cSaintMartinIsland);
        markerListChittagong.add(cPatengaBeach);
        markerListChittagong.add(cHimchori);
        markerListChittagong.add(cShalbanBihar);
        markerListChittagong.add(cSajek);
        for (Marker marker : markerListChittagong) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();

                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Cox's Bazar Beach")) {
                    mapDialog(markerTitle, "", "Cox's Bazar,Chittagong", "");

                } else if (markerTitle.equals("Boga Lake")) {
                    mapDialog(markerTitle, "", "bandarban,Chittagong", "");
                } else if (markerTitle.equals("Nilgiri Mountains")) {
                    mapDialog(markerTitle, "+8801769299999", "Bandarban-Thanchi Road, Nilgiri, Bandarban", "http://nilgiriresort.com/");
                } else if (markerTitle.equals("Saint Martin Island")) {
                    mapDialog(markerTitle, "", "West Beach", "http://saintmartinup.coxsbazar.gov.bd/");
                } else if (markerTitle.equals("Patenga Beach")) {
                    mapDialog(markerTitle, "", "চট্টগ্রাম", "");
                } else if (markerTitle.equals("Himchori")) {
                    mapDialog(markerTitle, "", "Cox's Bazar Marine Dr, কক্সবাজার", "");
                } else if (markerTitle.equals("Shalban Bihar")) {
                    mapDialog(markerTitle, "+8808174066", "Comilla University Road, Shalmanpur 3506", "http://www.comilla.gov.bd/site/tourist_spot/562da145-2147-11e7-8f57-286ed488c766/%E0%A6%B6%E0%A6%BE%E0%A6%B2%E0%A6%AC%E0%A6%A8%20%E0%A6%AC%E0%A7%8C%E0%A6%A6%E0%A7%8D%E0%A6%A7%20%E0%A6%AC%E0%A6%BF%E0%A6%B9%E0%A6%BE%E0%A6%B0");
                } else if (markerTitle.equals("Sajek")) {
                    mapDialog(markerTitle, "+8801886666021", "Dighinala - Sajek Road, Sajek", "https://www.facebook.com/touromadhk");
                }


                return false;
            }
        });

    }

    private void showRangpurAll() {

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Marker rTajhatPalace, rTownHall, rMithapukurBaraMosque, rBegumRokeyaMemorial, rKellabandMosqueMasjid, rItakumariJamindarBari, rManthanaZamindarBari;
        LatLng _rTajhatPalace, _rTownHall, _rMithapukurBaraMosque, _rBegumRokeyaMemorial, _rKellabandMosqueMasjid, _rItakumariJamindarBari, _rManthanaZamindarBari;

        _rTajhatPalace = new LatLng(25.725278, 89.2777146);
        _rTownHall = new LatLng(25.7541887, 89.2486784);
        _rMithapukurBaraMosque = new LatLng(25.5782226, 89.2675446);
        _rBegumRokeyaMemorial = new LatLng(25.5783656, 89.1996923);
        _rKellabandMosqueMasjid = new LatLng(25.7758063, 89.2070068);
        _rItakumariJamindarBari = new LatLng(25.7167092, 89.3893576);
        _rManthanaZamindarBari = new LatLng(25.7644852, 89.3246633);


        rTajhatPalace = mMap.addMarker(new MarkerOptions().position(_rTajhatPalace).title("Tajhat Palace").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        rTownHall = mMap.addMarker(new MarkerOptions().position(_rTownHall).title("Town Hall").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        rMithapukurBaraMosque = mMap.addMarker(new MarkerOptions().position(_rMithapukurBaraMosque).title("Mithapukur Bara Mosque").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rBegumRokeyaMemorial = mMap.addMarker(new MarkerOptions().position(_rBegumRokeyaMemorial).title("Begum Rokeya Memorial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rKellabandMosqueMasjid = mMap.addMarker(new MarkerOptions().position(_rKellabandMosqueMasjid).title("Kellaband Mosque (Masjid)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        rItakumariJamindarBari = mMap.addMarker(new MarkerOptions().position(_rItakumariJamindarBari).title("Itakumari Jamindar Bari").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        rManthanaZamindarBari = mMap.addMarker(new MarkerOptions().position(_rManthanaZamindarBari).title("Manthana Zamindar Bari").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListRangpur.add(rTajhatPalace);
        markerListRangpur.add(rTownHall);
        markerListRangpur.add(rMithapukurBaraMosque);
        markerListRangpur.add(rBegumRokeyaMemorial);
        markerListRangpur.add(rKellabandMosqueMasjid);
        markerListRangpur.add(rItakumariJamindarBari);
        markerListRangpur.add(rManthanaZamindarBari);
        for (Marker marker : markerListRangpur) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();

                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Tajhat Palace")) {
                    mapDialog(markerTitle, "", "Tajhat Road, Rangpur 5400", "http://www.archaeology.gov.bd/");
                } else if (markerTitle.equals("Town Hall")) {
                    mapDialog(markerTitle, "", "Rangpur", "");
                } else if (markerTitle.equals("Mithapukur Bara Mosque")) {
                    mapDialog(markerTitle, "", "Durgapur,Rangpur", "");
                } else if (markerTitle.equals("Begum Rokeya Memorial")) {
                    mapDialog(markerTitle, "", "Pairaband,Rangpur", "");
                } else if (markerTitle.equals("Kellaband Mosque (Masjid)")) {
                    mapDialog(markerTitle, "+8801723577008", "Rangpur - Dinajpur Hwy, Rangpur", "");
                } else if (markerTitle.equals("Itakumari Jamindar Bari")) {
                    mapDialog(markerTitle, "", "Itakumari,Rangpur", "");
                } else if (markerTitle.equals("Manthana Zamindar Bari")) {
                    mapDialog(markerTitle, "", "Fire Station Rd, Rangpur", "");
                }

                return false;
            }
        });
    }

    private void showSylhetAll() {


        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Marker sRatargulGuainghatSylhet, sLalakhal, sTanguarHaor, sSreemongolAround, sBisnakandi, sJaflong, sLuvachora;
        LatLng _sRatargulGuainghatSylhet, _sLalakhal, _sTanguarHaor, _sSreemongolAround, _sBisnakandi, _sJaflong, _sLuvachora;

        _sRatargulGuainghatSylhet = new LatLng(25.0100538, 91.9158328);
        _sLalakhal = new LatLng(25.107265, 92.1690702);
        _sTanguarHaor = new LatLng(25.1400478, 91.0861391);
        _sSreemongolAround = new LatLng(24.3135628, 91.7075346);
        _sBisnakandi = new LatLng(25.1700575, 91.8815803);
        _sJaflong = new LatLng(25.7167092, 89.3893576);
        _sLuvachora = new LatLng(25.0711925, 92.3351013);


        sRatargulGuainghatSylhet = mMap.addMarker(new MarkerOptions().position(_sRatargulGuainghatSylhet).title("Ratargul, Guainghat Sylhet").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        sLalakhal = mMap.addMarker(new MarkerOptions().position(_sLalakhal).title("Lala khal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        sTanguarHaor = mMap.addMarker(new MarkerOptions().position(_sTanguarHaor).title("Tanguar Haor").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        sSreemongolAround = mMap.addMarker(new MarkerOptions().position(_sSreemongolAround).title("Sreemongol & Around").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        sBisnakandi = mMap.addMarker(new MarkerOptions().position(_sBisnakandi).title("Bisnakandi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        sJaflong = mMap.addMarker(new MarkerOptions().position(_sJaflong).title("Jaflong").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        sLuvachora = mMap.addMarker(new MarkerOptions().position(_sLuvachora).title("Luvachora").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListSylhet.add(sRatargulGuainghatSylhet);
        markerListSylhet.add(sLalakhal);
        markerListSylhet.add(sTanguarHaor);
        markerListSylhet.add(sSreemongolAround);
        markerListSylhet.add(sBisnakandi);
        markerListSylhet.add(sJaflong);
        markerListSylhet.add(sLuvachora);
        for (Marker marker : markerListSylhet) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();

                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Ratargul, Guainghat Sylhet")) {
                    mapDialog(markerTitle, "", "Sylhet", "");

                } else if (markerTitle.equals("Lala khal")) {
                    mapDialog(markerTitle, "", "Sylhet", "");
                } else if (markerTitle.equals("Tanguar Hao")) {
                    mapDialog(markerTitle, "+8801815162600", "Dharmpasha - Tahirpur Road, 3030", "https://www.facebook.com/TanguarHaorBD/");
                } else if (markerTitle.equals("Sreemongol & Around")) {
                    mapDialog(markerTitle, "", "Sreemangal. Division, Sylhet Division. District, Moulvibazar District", "");
                } else if (markerTitle.equals("Bisnakandi")) {
                    mapDialog(markerTitle, "", "বিছনাকান্দি ,সিলেট", "");
                } else if (markerTitle.equals("Jaflong")) {
                    mapDialog(markerTitle, "", "Balla Ghaut Rd, জাফলং,Sylhet", "");
                } else if (markerTitle.equals("Luvachora")) {
                    mapDialog(markerTitle, "+8801827871420", "Kanaighat,Sylhet", "http://www.fb.me/loobacherra");
                }


                return false;
            }
        });

    }

    private void checkPermission() {

        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                // Toast.makeText(MyMapsActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();

                isCheckPermission = true;
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), "");
                intent.setData(uri);
                startActivity(intent);

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                permissionToken.continuePermissionRequest();

            }
        }).check();
    }


    private void init() {
        markerListBoat = new ArrayList<>();
        markerListBus = new ArrayList<>();
        markerListDhaka = new ArrayList<>();
        markerListMymensingh = new ArrayList<>();
        markerListRajshahi = new ArrayList<>();
        markerListBarishal = new ArrayList<>();
        markerListKhulna = new ArrayList<>();
        markerListChittagong = new ArrayList<>();
        markerListSylhet = new ArrayList<>();
        markerListRangpur = new ArrayList<>();
        fav = findViewById(R.id.flat_button);

        searchET = findViewById(R.id.searchET);
        searchIV = findViewById(R.id.searchIV);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        checkPermission();


        if (globalProvider) {

            //===========Division check==========
            if (msg == null) {


            } else if (msg.equals("dhaka")) {

                showDhakaAll();

            } else if (msg.equals("mymensingh")) {
                showMymensinghAll();

            } else if (msg.equals("barishal")) {

                showBarishalAll();

            } else if (msg.equals("rajshahi")) {
                showRajshahiAll();

            } else if (msg.equals("khulna")) {
                showKhulnaAll();

            } else if (msg.equals("chittagong")) {
                showChittagoAngAll();


            } else if (msg.equals("rangpur")) {
                showRangpurAll();

            } else if (msg.equals("sylhet")) {
                showSylhetAll();
            }


            if (tourCategories == null && msg == null) {
                mapAllMarker();
            } else if (tourCategories == null && msg != null) {


            } else if (tourCategories != null && msg != null) {

            } else if (tourCategories.equals("bus") && msg == null) {
                busTour();
            } else if (tourCategories.equals("boat") && msg == null) {
                boatTour();
            }





            //==========get Description address=========================

            if (address == null || address.equals("Place")) {

            }  else {
                getDescriptionsAddress();
            }


            searchIV.setOnClickListener(this::geoLocate);



        }


        mLocations = new FusedLocationProviderClient(this);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getCurrentLocations();
            }
        });

    }


    private void busTour() {


        LatLng _tSB = new LatLng(23.8263456, 90.4121023);
        LatLng _tMB = new LatLng(23.8019036, 90.3963535);
        LatLng _hTB = new LatLng(23.8012878, 90.4027064);
        LatLng _rCT = new LatLng(23.7915758, 90.3933805);
        LatLng _nT = new LatLng(23.8263456, 90.412201);
        LatLng _mHB = new LatLng(23.8414846, 90.4001784);
        LatLng _bST = new LatLng(23.8263456, 90.4113539);
        LatLng _bTH = new LatLng(23.8386766, 90.3939728);
        LatLng _tATB = new LatLng(23.8423049, 90.3943978);
        LatLng _vT = new LatLng(23.8071437, 90.4048633);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        tSB = mMap.addMarker(new MarkerOptions().position(_tSB).title("Tour Solution BD | Tourist and Mini Bus Rent in Bangladesh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        tMB = mMap.addMarker(new MarkerOptions().position(_tMB).title("Tourist Minibus Bangladesh | Tourist Bus in Dhaka ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        hTB = mMap.addMarker(new MarkerOptions().position(_hTB).title("Holidays Tour in Bangladesh | Sundarban Tour From Khulna | Tourist Coach Rent").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rCT = mMap.addMarker(new MarkerOptions().position(_rCT).title("River Cruise & Tourist Mini Bus in Dhaka Bangladesh{Bdesh Tour Tourist Bus}").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        nT = mMap.addMarker(new MarkerOptions().position(_nT).title("Nijhoom Tours").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        mHB = mMap.addMarker(new MarkerOptions().position(_mHB).title("Mam Holidays Bangladesh|Dhaka City Tour|Tourism Company in Bangladesh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        bST = mMap.addMarker(new MarkerOptions().position(_bST).title("Bangladesh Scenic Tour").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).alpha(0.8f));
        bTH = mMap.addMarker(new MarkerOptions().position(_bTH).title("Bangladesh Travel Homes").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)).alpha(0.8f));
        tATB = mMap.addMarker(new MarkerOptions().position(_tATB).title("Tours And Trips Bangladesh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).alpha(0.8f));
        vT = mMap.addMarker(new MarkerOptions().position(_vT).title("Vacation Tours|Inbound and Outbound Tour Operator in Bangladeshr").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)).alpha(0.8f));
        markerListBus.add(tSB);
        markerListBus.add(tMB);
        markerListBus.add(hTB);
        markerListBus.add(rCT);
        markerListBus.add(nT);
        markerListBus.add(mHB);
        markerListBus.add(bST);
        markerListBus.add(bTH);
        markerListBus.add(tATB);
        markerListBus.add(vT);


        for (Marker marker : markerListBus) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 12));
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {


            @Override
            public boolean onMarkerClick(Marker marker) {
                String mapGetTitle = marker.getTitle();
                if (mapGetTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No Title found!", Toast.LENGTH_SHORT).show();
                }
                //=================Bus Tour============

                else if (mapGetTitle.equals("Tour Solution BD | Tourist and Mini Bus Rent in angladesh")) {
                    mapDialog(mapGetTitle, "01712-059129", "House#30, Road#16 Nikunja-2, Dhaka 1229", "https://toursolutionbd.com/");
                } else if (mapGetTitle.equals("Tourist Minibus Bangladesh | Tourist Bus in Dhaka ")) {
                    mapDialog(mapGetTitle, "01711-336825", "Plot 16, Rd 36, Dhaka 1212", "http://www.minibusbd.com/");
                } else if (mapGetTitle.equals("Holidays Tour in Bangladesh | Sundarban Tour From Khulna | Tourist Coach Rent")) {
                    mapDialog(mapGetTitle, "01678-076363", "Floor : 8, Apt: B7, 99 Gulshan Ave, Dhaka 1212", "http://www.holidays.com.bd/");
                } else if (mapGetTitle.equals("River Cruise & Tourist Mini Bus in Dhaka Bangladesh{Bdesh Tour Tourist Bus}")) {
                    mapDialog(mapGetTitle, "01716-596370", "Dhaka 1212", "https://tourist-mini-bus-in-dhaka.business.site/?utm_source=gmb&utm_medium=referral");
                } else if (mapGetTitle.equals("Nijhoom Tours")) {
                    mapDialog(mapGetTitle, "01799-002244", "House 6 (Ground Floor, Rd No. 17, Dhaka 1229", "https://nijhoom.com/");
                } else if (mapGetTitle.equals("Mam Holidays Bangladesh|Dhaka City Tour|Tourism Company in Bangladesh")) {
                    mapDialog(mapGetTitle, "01722-594595", "Aman Shopping Complex (2nd Floor, Shahid Latif Rd, Dhaka 1230", "http://www.mamholidaysbangladesh.com/");
                } else if (mapGetTitle.equals("Bangladesh Scenic Tour")) {
                    mapDialog(mapGetTitle, "01722-286061", " House # 53 রোড নং-২০, Dhaka 1229", "https://www.bangladeshscenictours.com/");
                } else if (mapGetTitle.equals("Bangladesh Travel Homes")) {
                    mapDialog(mapGetTitle, "01716-224082", "House-20, Road-12, Sector-01, Uttara Model Town, Dhaka 1230", "http://www.bdtravelhomes.net/");
                } else if (mapGetTitle.equals("Tours And Trips Bangladesh")) {
                    mapDialog(mapGetTitle, "01715-186657", "Flat 2B, House, 51/E Road-13/B, Dhaka 1230", "https://www.toursntripsbd.com/");
                } else if (mapGetTitle.equals("Vacation Tours|Inbound and Outbound Tour Operator in Bangladeshr")) {
                    mapDialog(mapGetTitle, "01673496963", "Confidence Center, Suite No: 332, 2nd Floor Progoti Sarani, Bus Stand, Dhaka 1212", "https://www.vacationtoursbd.com/index.php");
                }


                return false;
            }
        });

    }

    private void boatTour() {


        LatLng _bangladesh_Eco_Adventure = new LatLng(23.7994327, 90.4052562);
        LatLng _dhaka_River_Cruise = new LatLng(23.8222047, 90.4219455);
        LatLng _rocket_Steamer_Boat_Station = new LatLng(23.7644838, 90.3421606);
        LatLng _viking_Marina = new LatLng(23.8269771, 90.4167901);
        LatLng _the_Bengal_Tours_Ltd = new LatLng(23.8072967, 90.3946949);
        LatLng _sundarban_Tour_Operators = new LatLng(23.7775584, 90.3789176);
        LatLng _sundarban_boat_tour_agent = new LatLng(23.1611873, 89.3230908);
        LatLng _boiddar_Bazar_Boat_Terminal = new LatLng(23.7339555, 90.3717219);
        LatLng _royal_Bengal_Tours = new LatLng(23.8270416, 90.3629942);
        LatLng _sundarban_Tour = new LatLng(23.1630109, 89.3230908);
        LatLng _bangladesh_Scenic_Tours = new LatLng(23.8282688, 90.4138487);
        LatLng _ever_Green_Tours = new LatLng(23.5651278, 88.4977745);
        LatLng _trip_to_the_Chittagong_hill_tracts = new LatLng(23.1177411, 90.1831167);
        LatLng _bangladesh_tours = new LatLng(23.7774799, 90.3789175);
        LatLng _high_Speed_Boat_Stand = new LatLng(23.7284611, 90.3640828);
        LatLng _naria_Speed_Boat_Ghat = new LatLng(23.5769085, 89.5070501);
        LatLng _boat_of_Sindbad = new LatLng(24.4529335, 90.4649963);
        LatLng _sundarban_Ac_boat_in_khulna = new LatLng(23.5651278, 88.4977745);

        String title = "Marker in Dhaka,Nikunja,2";
        bangladesh_Eco_Adventure = mMap.addMarker(new MarkerOptions().position(_bangladesh_Eco_Adventure).title("Bangladesh Eco Adventure").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        dhaka_River_Cruise = mMap.addMarker(new MarkerOptions().position(_dhaka_River_Cruise).title("Dhaka River Cruise").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        rocket_Steamer_Boat_Station = mMap.addMarker(new MarkerOptions().position(_rocket_Steamer_Boat_Station).title("Rocket Steamer Boat Station").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        viking_Marina = mMap.addMarker(new MarkerOptions().position(_viking_Marina).title("Viking Marina").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        the_Bengal_Tours_Ltd = mMap.addMarker(new MarkerOptions().position(_the_Bengal_Tours_Ltd).title("The Bengal Tours Ltd.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        sundarban_Tour_Operators = mMap.addMarker(new MarkerOptions().position(_sundarban_Tour_Operators).title("Sundarban Tour Operators").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        sundarban_boat_tour_agent = mMap.addMarker(new MarkerOptions().position(_sundarban_boat_tour_agent).title("Sundarban boat tour agent").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).alpha(0.8f));
        boiddar_Bazar_Boat_Terminal = mMap.addMarker(new MarkerOptions().position(_boiddar_Bazar_Boat_Terminal).title("Boiddar Bazar Boat Terminal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)).alpha(0.8f));
        royal_Bengal_Tours = mMap.addMarker(new MarkerOptions().position(_royal_Bengal_Tours).title("Royal Bengal Tours").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).alpha(0.8f));
        sundarban_Tour = mMap.addMarker(new MarkerOptions().position(_sundarban_Tour).title("Sundarban Tour").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)).alpha(0.8f));
        bangladesh_Scenic_Tours = mMap.addMarker(new MarkerOptions().position(_bangladesh_Scenic_Tours).title("Bangladesh Scenic Tours").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        ever_Green_Tours = mMap.addMarker(new MarkerOptions().position(_ever_Green_Tours).title("Ever Green Tours").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        trip_to_the_Chittagong_hill_tracts = mMap.addMarker(new MarkerOptions().position(_trip_to_the_Chittagong_hill_tracts).title("Trip to the Chittagong hill tracts").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        high_Speed_Boat_Stand = mMap.addMarker(new MarkerOptions().position(_high_Speed_Boat_Stand).title("High Speed Boat Stand").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        bangladesh_tours = mMap.addMarker(new MarkerOptions().position(_bangladesh_tours).title("Bangladesh tours").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        naria_Speed_Boat_Ghat = mMap.addMarker(new MarkerOptions().position(_naria_Speed_Boat_Ghat).title("Naria Speed Boat Ghat").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).alpha(0.8f));
        boat_of_Sindbad = mMap.addMarker(new MarkerOptions().position(_boat_of_Sindbad).title("সিন্দাবাদ তরী (Boat of Sindbad)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)).alpha(0.8f));
        sundarban_Ac_boat_in_khulna = mMap.addMarker(new MarkerOptions().position(_sundarban_Ac_boat_in_khulna).title("Sundarban A/c boat in khulna").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).alpha(0.8f));
        markerListBoat.add(bangladesh_Eco_Adventure);
        markerListBoat.add(dhaka_River_Cruise);
        markerListBoat.add(rocket_Steamer_Boat_Station);
        markerListBoat.add(viking_Marina);
        markerListBoat.add(the_Bengal_Tours_Ltd);
        markerListBoat.add(sundarban_Tour_Operators);
        markerListBoat.add(sundarban_boat_tour_agent);
        markerListBoat.add(boiddar_Bazar_Boat_Terminal);
        markerListBoat.add(royal_Bengal_Tours);
        markerListBoat.add(sundarban_Tour);
        markerListBoat.add(bangladesh_Scenic_Tours);
        markerListBoat.add(ever_Green_Tours);
        markerListBoat.add(trip_to_the_Chittagong_hill_tracts);
        markerListBoat.add(high_Speed_Boat_Stand);
        markerListBoat.add(bangladesh_tours);
        markerListBoat.add(naria_Speed_Boat_Ghat);
        markerListBoat.add(bangladesh_Eco_Adventure);
        markerListBoat.add(boat_of_Sindbad);
        markerListBoat.add(sundarban_Ac_boat_in_khulna);

        for (Marker marker : markerListBoat) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 12));
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {


            @Override
            public boolean onMarkerClick(Marker marker) {
                String mapGetTitle = marker.getTitle();
                if (mapGetTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No Title found!", Toast.LENGTH_SHORT).show();
                }
                //=================Boat Tour============
                else if (mapGetTitle.equals("Bangladesh Eco Adventure")) {
                    mapDialog(mapGetTitle, "01787-751865", "House no: 88, 981 P.O.Road, Dhaka 1212", "http://bangladeshecoadventure.com/");
                } else if (mapGetTitle.equals("Dhaka River Cruise")) {
                    mapDialog(mapGetTitle, "+8801716596370", "ঢাকা 1212", "http://www.bdeshtour.com/");
                } else if (mapGetTitle.equals("Rocket Steamer Boat Station")) {
                    mapDialog(mapGetTitle, "01717125174", "Dhaka", "http://www.biwtc.gov.bd/site/page/a5d8aed5-ccab-4c27-ab0d-26b792f939bf/-");
                } else if (mapGetTitle.equals("Viking Marina")) {
                    mapDialog(mapGetTitle, "01882-431377", "Pitolganj, Narayanganj", "http://vikingyachtbd.com/");
                } else if (mapGetTitle.equals("The Bengal Tours Ltd.")) {
                    mapDialog(mapGetTitle, "01775-105351", "House # 114, Road 15 Dhaka, 1213", "https://www.bengaltours.com/");
                } else if (mapGetTitle.equals("Sundarban Tour Operators")) {
                    mapDialog(mapGetTitle, "01715-093412", "Hazi Bahar Uddin Rd, Mongla port, Bagerhat, Khulna Division, Bangladesh, Hazi Bahar Uddin Rd, Mongla 9351", "http://www.expeditions-bd.com/");
                } else if (mapGetTitle.equals("Sundarban boat tour agen")) {
                    mapDialog(mapGetTitle, "01715-093412", "Mongla Ferry Ghat Rd, Mongla", "http://www.expeditions-bd.com/our-tours/sundarban-tours-2/");
                } else if (mapGetTitle.equals("Boiddar Bazar Boat Terminal")) {
                    mapDialog(mapGetTitle, "01976174432", "Sonargaon", "http://www.expeditions-bd.com/");
                } else if (mapGetTitle.equals("Royal Bengal Tours")) {
                    mapDialog(mapGetTitle, "01714-075718", "Avenue 8, Road 10, House 1132, Ground Floor, 1216", "https://www.royalbengaltours.com/");
                } else if (mapGetTitle.equals("Sundarban tour packages")) {
                    mapDialog(mapGetTitle, "01976-174432", "Mongla", "https://sundarbantourpackages.business.site/?utm_source=gmb&utm_medium=referral");
                } else if (mapGetTitle.equals("Bangladesh Scenic Tours")) {
                    mapDialog(mapGetTitle, "01722-286061", "House # 53 রোড নং-২০, Dhaka 1229", "https://www.bangladeshscenictours.com/");
                } else if (mapGetTitle.equals("Ever Green Tours")) {
                    mapDialog(mapGetTitle, "01767-033333", "B.I.W.T.A, 4 No Launch Ghat Rd, Khulna 9100", "No Website Found");
                } else if (mapGetTitle.equals("Trip to the Chittagong hill tracts")) {
                    mapDialog(mapGetTitle, "+8801715093412", "Bangladesh Expeditions 102/7 airport road, Kakoli, Banani, Dhaka-1213. Hot", "http://www.expeditions-bd.com/trip-to-rangamati-in-chittagong-hill-tracts/");
                } else if (mapGetTitle.equals("Bangladesh tours")) {
                    mapDialog(mapGetTitle, "+8801715093412", "ফকিরাপুল বাজার রোড, ঢাকা", "http://www.expeditions-bd.com/upcoming-holiday-packages/private-tours-in-bangladesh/");
                } else if (mapGetTitle.equals("সিন্দাবাদ তরী (Boat of Sindbad))")) {
                    mapDialog(mapGetTitle, "01877722850", "Tahirpur Bazar", "http://www.tourgroupbd.com/");
                } else if (mapGetTitle.equals("Sundarban A/c boat in khulna")) {
                    mapDialog(mapGetTitle, "01976-174432", "Voirob Stand Rd, Khulna", "http://www.expeditions-bd.com/");
                }


                return false;
            }
        });

    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GPS_REQUEST_CODE) {
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            boolean providerEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (providerEnable) {
                Toast.makeText(this, "GPS is Enable!", Toast.LENGTH_SHORT).show();
            } else if (!providerEnable) {
                Toast.makeText(this, "GPS is not Enable!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void mapAllMarker() {

        _dLalbaghFort = new LatLng(23.7188654, 90.3859709);
        _dAhsanManzilMuseum = new LatLng(23.7085964, 90.4038187);
        _dBangladeshNationalParliament = new LatLng(23.7624709, 90.3763924);
        _dBangladeshNationalZoo = new LatLng(23.8122314, 90.3447513);
        _dNationalMartyrs = new LatLng(23.911269, 90.2525913);
        _dBhawalRajbari = new LatLng(24.0006834, 90.4232361);
        _dSafariPark = new LatLng(24.1699598, 90.3943501);
        _dTangailDCLake = new LatLng(24.2651609, 89.9208906);
        _dAtiyaJameMosque = new LatLng(24.184085, 89.9092079);
        _dIshaKhanJangalbariFort = new LatLng(24.450535, 90.8397309);
        _dAustagramHaor = new LatLng(24.3210947, 90.8918538);
        _dNikliBeribadh = new LatLng(24.3266057, 90.9171865);
        _dChandrabatiMandir = new LatLng(24.4956276, 90.7987404);


        dLalbaghFort = mMap.addMarker(new MarkerOptions().position(_dLalbaghFort).title("Lalbagh Fort").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        dAhsanManzilMuseum = mMap.addMarker(new MarkerOptions().position(_dAhsanManzilMuseum).title("Ahsan Manzil Museum").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        dBangladeshNationalParliament = mMap.addMarker(new MarkerOptions().position(_dBangladeshNationalParliament).title("Bangladesh National Parliament").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        dBangladeshNationalZoo = mMap.addMarker(new MarkerOptions().position(_dBangladeshNationalZoo).title("Bangladesh National Zoo, Mirpur").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        dNationalMartyrs = mMap.addMarker(new MarkerOptions().position(_dNationalMartyrs).title("জাতীয় স্মৃতিসৌধ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        dBhawalRajbari = mMap.addMarker(new MarkerOptions().position(_dBhawalRajbari).title("Bhawal Rajbari").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        dSafariPark = mMap.addMarker(new MarkerOptions().position(_dSafariPark).title("Bangabandhu Sheikh Mujib Safari Park, Gazipur").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dTangailDCLake = mMap.addMarker(new MarkerOptions().position(_dTangailDCLake).title("Tangail DC Lake").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dAtiyaJameMosque = mMap.addMarker(new MarkerOptions().position(_dAtiyaJameMosque).title("Atiya Jame Mosque").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dIshaKhanJangalbariFort = mMap.addMarker(new MarkerOptions().position(_dIshaKhanJangalbariFort).title("Isha Khan's Jangalbari Fort").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dAustagramHaor = mMap.addMarker(new MarkerOptions().position(_dAustagramHaor).title("Austagram Haor").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dNikliBeribadh = mMap.addMarker(new MarkerOptions().position(_dNikliBeribadh).title("Nikli Beribadh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        dChandrabatiMandir = mMap.addMarker(new MarkerOptions().position(_dChandrabatiMandir).title("Chandrabati Mandir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListDhaka.add(dLalbaghFort);
        markerListDhaka.add(dAhsanManzilMuseum);
        markerListDhaka.add(dBangladeshNationalParliament);
        markerListDhaka.add(dBangladeshNationalZoo);
        markerListDhaka.add(dNationalMartyrs);
        markerListDhaka.add(dBhawalRajbari);
        markerListDhaka.add(dSafariPark);
        markerListDhaka.add(dTangailDCLake);
        markerListDhaka.add(dAtiyaJameMosque);
        markerListDhaka.add(dIshaKhanJangalbariFort);
        markerListDhaka.add(dAustagramHaor);
        markerListDhaka.add(dChandrabatiMandir);

        for (Marker marker : markerListDhaka) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        //=====================Mymensingh====================

        _mMusium = new LatLng(24.7607552, 90.1253969);
        _mhasanManjil = new LatLng(24.7611197, 90.4051734);
        _mShashiLodge = new LatLng(24.7617618, 90.4008346);
        _mZaynalAbedin = new LatLng(24.6583369, 90.40593);
        _mAlexanderCastle = new LatLng(24.7657479, 90.3998389);
        _mMoynaDeep = new LatLng(24.7130507, 90.4561053);
        _mBirishiri = new LatLng(25.1050596, 90.6621301);
        _mMuktagachaRajbari = new LatLng(24.6643676, 90.1960377);


        mMusium = mMap.addMarker(new MarkerOptions().position(_mMusium).title("Mymensingh Museum").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        mhasanManjil = mMap.addMarker(new MarkerOptions().position(_mhasanManjil).title("Hasan Monzil").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        mShashiLodge = mMap.addMarker(new MarkerOptions().position(_mShashiLodge).title("Shashi Lodge").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        mZaynalAbedin = mMap.addMarker(new MarkerOptions().position(_mZaynalAbedin).title("শিল্পাচার্য জয়নুল আবেদিন সংগ্রহশালা").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        mAlexanderCastle = mMap.addMarker(new MarkerOptions().position(_mAlexanderCastle).title("Alexander Castle").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        mMoynaDeep = mMap.addMarker(new MarkerOptions().position(_mMoynaDeep).title("Moyna Deep").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        mBirishiri = mMap.addMarker(new MarkerOptions().position(_mBirishiri).title("Birirshiri").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        mMuktagachaRajbari = mMap.addMarker(new MarkerOptions().position(_mMuktagachaRajbari).title("মুক্তাগাছা জমিদার বাড়ি").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).alpha(0.8f));

        markerListMymensingh.add(mMusium);
        markerListMymensingh.add(mhasanManjil);
        markerListMymensingh.add(mShashiLodge);
        markerListMymensingh.add(mZaynalAbedin);
        markerListMymensingh.add(mAlexanderCastle);
        markerListMymensingh.add(mMoynaDeep);
        markerListMymensingh.add(mBirishiri);
        markerListMymensingh.add(mMuktagachaRajbari);
        for (Marker marker : markerListMymensingh) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        //=============barishal==========

        _bKuakataSeaBeach = new LatLng(21.8158454, 90.1179308);
        _bSonarChar = new LatLng(21.837258, 90.486059);
        _bGuavaMarket = new LatLng(22.7337815, 90.1482268);
        _bGuthiaMosque = new LatLng(22.7029366, 90.3444095);
        _bFatrarChar = new LatLng(21.8664743, 90.0751627);
        _bDurgasagar = new LatLng(22.760991, 90.2873182);
        _bLeburChar = new LatLng(21.8428104, 90.0855411);


        bKuakataSeaBeach = mMap.addMarker(new MarkerOptions().position(_bKuakataSeaBeach).title("Kuakata Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        bSonarChar = mMap.addMarker(new MarkerOptions().position(_bSonarChar).title("Sonar char").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        bGuavaMarket = mMap.addMarker(new MarkerOptions().position(_bGuavaMarket).title("Guava Market").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        bGuthiaMosque = mMap.addMarker(new MarkerOptions().position(_bGuthiaMosque).title("Guthia Mosque").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        bFatrarChar = mMap.addMarker(new MarkerOptions().position(_bFatrarChar).title("Fatrar Char").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        bDurgasagar = mMap.addMarker(new MarkerOptions().position(_bDurgasagar).title("Durga Sagar").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        bLeburChar = mMap.addMarker(new MarkerOptions().position(_bLeburChar).title("Lebur Char").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListBarishal.add(bKuakataSeaBeach);
        markerListBarishal.add(bSonarChar);
        markerListBarishal.add(bGuavaMarket);
        markerListBarishal.add(bGuthiaMosque);
        markerListBarishal.add(bFatrarChar);
        markerListBarishal.add(bDurgasagar);
        markerListBarishal.add(bLeburChar);
        for (Marker marker : markerListBarishal) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        //===========Rajshahi============

        _rBijoySagar = new LatLng(24.3731541, 88.6469974);
        _rShahidMinar = new LatLng(24.3682765, 88.6372983);
        _rPadmaGarden = new LatLng(24.3615844, 88.5949244);
        _rVarendraResearchMuseum = new LatLng(24.3670577, 88.5903295);
        _rBaghaShahiMasjid = new LatLng(24.1959114, 88.8372124);
        _rBoroKuthi = new LatLng(24.3621093, 88.5959846);
        _rPuthiaRajbariComplex = new LatLng(24.3618971, 88.8345278);


        rBijoySagar = mMap.addMarker(new MarkerOptions().position(_rBijoySagar).title("Bijoy Sagar, Rajshahi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        rShahidMinar = mMap.addMarker(new MarkerOptions().position(_rShahidMinar).title("Shahid Minar, Rajshahir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        rPadmaGarden = mMap.addMarker(new MarkerOptions().position(_rPadmaGarden).title("Padma Garden").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rVarendraResearchMuseum = mMap.addMarker(new MarkerOptions().position(_rVarendraResearchMuseum).title("Varendra Research Museum").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rBaghaShahiMasjid = mMap.addMarker(new MarkerOptions().position(_rBaghaShahiMasjid).title("Bagha Shahi Masjid").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        rBoroKuthi = mMap.addMarker(new MarkerOptions().position(_rBoroKuthi).title("Boro Kuthi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        rPuthiaRajbariComplex = mMap.addMarker(new MarkerOptions().position(_rPuthiaRajbariComplex).title("Puthia Rajbari Complex").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListRajshahi.add(rBijoySagar);
        markerListRajshahi.add(rShahidMinar);
        markerListRajshahi.add(rPadmaGarden);
        markerListRajshahi.add(rVarendraResearchMuseum);
        markerListRajshahi.add(rBaghaShahiMasjid);
        markerListRajshahi.add(rBoroKuthi);
        markerListRajshahi.add(rPuthiaRajbariComplex);
        for (Marker marker : markerListRajshahi) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }

        //===============Khulna==============


        _kSundarbanNationalPark = new LatLng(24.3731541, 88.6469974);
        _kSajnekhali = new LatLng(24.3682765, 88.6372983);
        _kHironPointBangladesh = new LatLng(24.3615844, 88.5949244);
        _kSudhanyakhaliWatchTower = new LatLng(24.3670577, 88.5903295);
        _kDobankiWatchTower = new LatLng(24.1959114, 88.8372124);
        _kJamtolaBeach = new LatLng(24.3621093, 88.5959846);
        _kDobankiCamp = new LatLng(24.3618971, 88.8345278);


        kSundarbanNationalPark = mMap.addMarker(new MarkerOptions().position(_kSundarbanNationalPark).title("Sundarban National Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        kSajnekhali = mMap.addMarker(new MarkerOptions().position(_kSajnekhali).title("Sajne khali").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        kHironPointBangladesh = mMap.addMarker(new MarkerOptions().position(_kHironPointBangladesh).title("Hiron Point Bangladesh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        kSudhanyakhaliWatchTower = mMap.addMarker(new MarkerOptions().position(_kSudhanyakhaliWatchTower).title("Sudhanya khali Watch Tower").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        kDobankiWatchTower = mMap.addMarker(new MarkerOptions().position(_kDobankiWatchTower).title("Dobanki Watch Tower").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        kJamtolaBeach = mMap.addMarker(new MarkerOptions().position(_kJamtolaBeach).title("Jamtola Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        kDobankiCamp = mMap.addMarker(new MarkerOptions().position(_kDobankiCamp).title("Dobanki Camp").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListKhulna.add(kSundarbanNationalPark);
        markerListKhulna.add(kSajnekhali);
        markerListKhulna.add(kHironPointBangladesh);
        markerListKhulna.add(kSudhanyakhaliWatchTower);
        markerListKhulna.add(kDobankiWatchTower);
        markerListKhulna.add(kJamtolaBeach);
        markerListKhulna.add(kDobankiCamp);
        for (Marker marker : markerListKhulna) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        //===============chittagong==============


        _cCoxBazarBeach = new LatLng(21.4285152, 91.9614311);
        _cBogaLake = new LatLng(21.9803442, 92.4675491);
        _cNilgiriMountains = new LatLng(21.911878, 92.3232463);
        _cSaintMartinIsland = new LatLng(20.6059155, 92.2919519);
        _cPatengaBeach = new LatLng(22.2359895, 91.7868103);
        _cHimchori = new LatLng(21.3548955, 92.0240666);
        _cShalbanBihar = new LatLng(23.4262578, 91.1355817);
        _cSajek = new LatLng(23.3814161, 92.2861862);


        cCoxBazarBeach = mMap.addMarker(new MarkerOptions().position(_cCoxBazarBeach).title("Cox's Bazar Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        cBogaLake = mMap.addMarker(new MarkerOptions().position(_cBogaLake).title("Boga Lake").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        cNilgiriMountains = mMap.addMarker(new MarkerOptions().position(_cNilgiriMountains).title("Nilgiri Mountains").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        cSaintMartinIsland = mMap.addMarker(new MarkerOptions().position(_cSaintMartinIsland).title("Saint Martin Island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        cPatengaBeach = mMap.addMarker(new MarkerOptions().position(_cPatengaBeach).title("Patenga Beach").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        cHimchori = mMap.addMarker(new MarkerOptions().position(_cHimchori).title("Himchori").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        cShalbanBihar = mMap.addMarker(new MarkerOptions().position(_cShalbanBihar).title("Shalban Bihar").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));
        cSajek = mMap.addMarker(new MarkerOptions().position(_cSajek).title("Sajek").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListChittagong.add(cCoxBazarBeach);
        markerListChittagong.add(cBogaLake);
        markerListChittagong.add(cNilgiriMountains);
        markerListChittagong.add(cSaintMartinIsland);
        markerListChittagong.add(cPatengaBeach);
        markerListChittagong.add(cHimchori);
        markerListChittagong.add(cShalbanBihar);
        markerListChittagong.add(cSajek);
        for (Marker marker : markerListChittagong) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        //===============Rangpur==============

        _rTajhatPalace = new LatLng(25.725278, 89.2777146);
        _rTownHall = new LatLng(25.7541887, 89.2486784);
        _rMithapukurBaraMosque = new LatLng(25.5782226, 89.2675446);
        _rBegumRokeyaMemorial = new LatLng(25.5783656, 89.1996923);
        _rKellabandMosqueMasjid = new LatLng(25.7758063, 89.2070068);
        _rItakumariJamindarBari = new LatLng(25.7167092, 89.3893576);
        _rManthanaZamindarBari = new LatLng(25.7644852, 89.3246633);


        rTajhatPalace = mMap.addMarker(new MarkerOptions().position(_rTajhatPalace).title("Tajhat Palace").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        rTownHall = mMap.addMarker(new MarkerOptions().position(_rTownHall).title("Town Hall").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        rMithapukurBaraMosque = mMap.addMarker(new MarkerOptions().position(_rMithapukurBaraMosque).title("Mithapukur Bara Mosque").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rBegumRokeyaMemorial = mMap.addMarker(new MarkerOptions().position(_rBegumRokeyaMemorial).title("Begum Rokeya Memorial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        rKellabandMosqueMasjid = mMap.addMarker(new MarkerOptions().position(_rKellabandMosqueMasjid).title("Kellaband Mosque (Masjid)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        rItakumariJamindarBari = mMap.addMarker(new MarkerOptions().position(_rItakumariJamindarBari).title("Itakumari Jamindar Bari").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        rManthanaZamindarBari = mMap.addMarker(new MarkerOptions().position(_rManthanaZamindarBari).title("Manthana Zamindar Bari").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListRangpur.add(rTajhatPalace);
        markerListRangpur.add(rTownHall);
        markerListRangpur.add(rMithapukurBaraMosque);
        markerListRangpur.add(rBegumRokeyaMemorial);
        markerListRangpur.add(rKellabandMosqueMasjid);
        markerListRangpur.add(rItakumariJamindarBari);
        markerListRangpur.add(rManthanaZamindarBari);
        for (Marker marker : markerListRangpur) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        //===============Sylhet==============


        _sRatargulGuainghatSylhet = new LatLng(25.0100538, 91.9158328);
        _sLalakhal = new LatLng(25.107265, 92.1690702);
        _sTanguarHaor = new LatLng(25.1400478, 91.0861391);
        _sSreemongolAround = new LatLng(24.3135628, 91.7075346);
        _sBisnakandi = new LatLng(25.1700575, 91.8815803);
        _sJaflong = new LatLng(25.7167092, 89.3893576);
        _sLuvachora = new LatLng(25.0711925, 92.3351013);


        sRatargulGuainghatSylhet = mMap.addMarker(new MarkerOptions().position(_sRatargulGuainghatSylhet).title("Ratargul, Guainghat Sylhet").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));
        sLalakhal = mMap.addMarker(new MarkerOptions().position(_sLalakhal).title("Lala khal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).alpha(0.8f));
        sTanguarHaor = mMap.addMarker(new MarkerOptions().position(_sTanguarHaor).title("Tanguar Haor").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        sSreemongolAround = mMap.addMarker(new MarkerOptions().position(_sSreemongolAround).title("Sreemongol & Around").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.8f));
        sBisnakandi = mMap.addMarker(new MarkerOptions().position(_sBisnakandi).title("Bisnakandi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).alpha(0.8f));
        sJaflong = mMap.addMarker(new MarkerOptions().position(_sJaflong).title("Jaflong").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).alpha(0.8f));
        sLuvachora = mMap.addMarker(new MarkerOptions().position(_sLuvachora).title("Luvachora").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).alpha(0.8f));

        markerListSylhet.add(sRatargulGuainghatSylhet);
        markerListSylhet.add(sLalakhal);
        markerListSylhet.add(sTanguarHaor);
        markerListSylhet.add(sSreemongolAround);
        markerListSylhet.add(sBisnakandi);
        markerListSylhet.add(sJaflong);
        markerListSylhet.add(sLuvachora);
        for (Marker marker : markerListSylhet) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8));
        }
        //===========Map Click===========
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();
                if (markerTitle == null) {
                    Toast.makeText(MyMapsActivity.this, "No title found!", Toast.LENGTH_SHORT).show();
                } else if (markerTitle.equals("Lalbagh Fort")) {
                    mapDialog(markerTitle, "+88029673018", "Lalbagh Rd, Dhaka 1211", "http://www.archaeology.gov.bd/");

                } else if (markerTitle.equals("Ahsan Manzil Museum")) {
                    mapDialog(markerTitle, "+880257391122", "Latif Complex, ইসলামপুর রোড, ঢাকা", "No Website found!");
                } else if (markerTitle.equals("Bangladesh National Parliament")) {
                    mapDialog(markerTitle, "+880255028840", "Dhaka 1207", "http://www.parliament.gov.bd/");
                } else if (markerTitle.equals("Bangladesh National Zoo, Mirpur")) {
                    mapDialog(markerTitle, "+880258053030", "চিড়িয়াখানা রোড, ঢাকা 1216", "http://bnzoo.org/");
                } else if (markerTitle.equals("জাতীয় স্মৃতিসৌধ")) {
                    mapDialog(markerTitle, "No Phone Number found!", "Dhaka - Aricha Hwy, সাভার ইউনিয়ন 1344", "No Website Found!");
                } else if (markerTitle.equals("Bhawal Rajbari")) {
                    mapDialog(markerTitle, "No Phone Number found!", "A/132 Bazar Rd, Gazipur 1700", "No Website Found!");
                } else if (markerTitle.equals("Bangabandhu Sheikh Mujib Safari Park, Gazipur")) {
                    mapDialog(markerTitle, "+8801842434401", "1340 Safari Park Rd, শ্রীপুর", "http://www.safariparkgazipur.info.bd/");
                } else if (markerTitle.equals("Tangail DC Lake")) {
                    mapDialog(markerTitle, "+8801882429591", "টাঙ্গাইল", "No Website Found!");
                } else if (markerTitle.equals("Atiya Jame Mosque")) {
                    mapDialog(markerTitle, "No Phone Number found!", "টাঙ্গাইল", "No Website Found!");
                } else if (markerTitle.equals("Isha Khan's Jangalbari Fort")) {
                    mapDialog(markerTitle, "No Phone Number found!", "জঙ্গলবাড়ী,করিমগঞ্জ উপজেলা,কিশোরগঞ্জ.", "No Website Found!");
                } else if (markerTitle.equals("Austagram Haor")) {
                    mapDialog(markerTitle, "No Phone Number found!", "অষ্টগ্রাম হাওর, কিশোরগঞ্জ", "http://www.facebook.com/ExploreHaor");
                } else if (markerTitle.equals("Nikli Beribadh")) {
                    mapDialog(markerTitle, "No Phone Number found!", "Unnamed Road, নিকলি", "No Website Found!");
                } else if (markerTitle.equals("Chandrabati Mandir")) {
                    mapDialog(markerTitle, "No Phone Number found!", "কিশোরগঞ্জ - তারাইল রোড", "No Website Found!");
                } else if (markerTitle.equals("Mymensingh Museum")) {
                    mapDialog(markerTitle, "+8801758538909", "ময়মনসিংহ", "http://www.mymensingh.gov.bd/");

                } else if (markerTitle.equals("Hasan Monzil")) {
                    mapDialog(markerTitle, "+8801768570119", "ঈশাণ চক্রবর্ত্তী রোড, ময়মনসিংহ", "No website found!");
                } else if (markerTitle.equals("Shashi Lodge")) {
                    mapDialog(markerTitle, "+8801910610330", "Teachers Training Collage (women, কাচারী রোড, ময়মনসিংহ", "No website found!");
                } else if (markerTitle.equals("শিল্পাচার্য জয়নুল আবেদিন সংগ্রহশালা")) {
                    mapDialog(markerTitle, "+8809166960", "Park Road, Mymensingh", "https://zainulsangrahashala.org.bd/");
                } else if (markerTitle.equals("Alexander Castle")) {
                    mapDialog(markerTitle, "No phone found!", "Mymensingh", "No website found!");
                } else if (markerTitle.equals("Moyna Deep")) {
                    mapDialog(markerTitle, "No phone found!", "Charnilakshia Batipara,Mymensingh", "No website found!");
                } else if (markerTitle.equals("Birirshiri")) {
                    mapDialog(markerTitle, "No phone found!", "Birishiri, Durgapur", "No website found!");
                } else if (markerTitle.equals("মুক্তাগাছা জমিদার বাড়ি")) {
                    mapDialog(markerTitle, "+8801627651952", "College Rd, মুক্তাগাছা 2210", "https://muktagachha-jomidar-bari.business.site/?utm_source=gmb&utm_medium=referral");
                } else if (markerTitle.equals("Kuakata Beach")) {
                    mapDialog(markerTitle, "", "Kuakata,Barishal", "");

                } else if (markerTitle.equals("Sonar char")) {
                    mapDialog(markerTitle, "", "Sonar Char,Barishal", "");
                } else if (markerTitle.equals("Guava Market")) {
                    mapDialog(markerTitle, "", "আটঘর - নবগ্রাম রোড, আটঘর কুড়িয়ানা ইউনিয়ন", "");
                } else if (markerTitle.equals("Guthia Mosque")) {
                    mapDialog(markerTitle, "", "Barishal", "");
                } else if (markerTitle.equals("Fatrar Char")) {
                    mapDialog(markerTitle, "", "Barishal", "");
                } else if (markerTitle.equals("Durga Sagar")) {
                    mapDialog(markerTitle, "", "8213 স্বরুপকাঠি - বরিশাল রোড, মাধবপাশা", "");
                } else if (markerTitle.equals("Lebur Char")) {
                    mapDialog(markerTitle, "", "Barishal", "");
                } else if (markerTitle.equals("Bijoy Sagar, Rajshahi")) {
                    mapDialog(markerTitle, "", "Rajshahi", "");

                } else if (markerTitle.equals("Shahid Minar, Rajshahir")) {
                    mapDialog(markerTitle, "", "Rajshahi", "");
                } else if (markerTitle.equals("Padma Garden")) {
                    mapDialog(markerTitle, "", "Dorgapara Rajshahi College Pathway, Rajshahi", "");
                } else if (markerTitle.equals("Varendra Research Museum")) {
                    mapDialog(markerTitle, "+8801763002204", "রাজশাহী", "http://ru.ac.bd/");
                } else if (markerTitle.equals("Bagha Shahi Masjid")) {
                    mapDialog(markerTitle, "", "বাঘা,রাজশাহী", "");
                } else if (markerTitle.equals("Boro Kuthi")) {
                    mapDialog(markerTitle, "", "রাজশাহী", "");
                } else if (markerTitle.equals("Puthia Rajbari Complex")) {
                    mapDialog(markerTitle, "", "রাজশাহী", "");
                } else if (markerTitle.equals("Sundarban National Park")) {
                    mapDialog(markerTitle, "+8801915007769", "Mongla,Khulna", "");

                } else if (markerTitle.equals("Sajne khali")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                } else if (markerTitle.equals("Hiron Point Bangladesh")) {
                    mapDialog(markerTitle, "", "Khulna", "");
                } else if (markerTitle.equals("Sudhanya khali Watch Tower")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                } else if (markerTitle.equals("Dobanki Watch Tower")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                } else if (markerTitle.equals("Jamtola Beach")) {
                    mapDialog(markerTitle, "", "Khulna", "");
                } else if (markerTitle.equals("Dobanki Camp")) {
                    mapDialog(markerTitle, "", "West Bengal, India", "");
                } else if (markerTitle.equals("Cox's Bazar Beach")) {
                    mapDialog(markerTitle, "", "Cox's Bazar,Chittagong", "");

                } else if (markerTitle.equals("Boga Lake")) {
                    mapDialog(markerTitle, "", "bandarban,Chittagong", "");
                } else if (markerTitle.equals("Nilgiri Mountains")) {
                    mapDialog(markerTitle, "+8801769299999", "Bandarban-Thanchi Road, Nilgiri, Bandarban", "http://nilgiriresort.com/");
                } else if (markerTitle.equals("Saint Martin Island")) {
                    mapDialog(markerTitle, "", "West Beach", "http://saintmartinup.coxsbazar.gov.bd/");
                } else if (markerTitle.equals("Patenga Beach")) {
                    mapDialog(markerTitle, "", "চট্টগ্রাম", "");
                } else if (markerTitle.equals("Himchori")) {
                    mapDialog(markerTitle, "", "Cox's Bazar Marine Dr, কক্সবাজার", "");
                } else if (markerTitle.equals("Shalban Bihar")) {
                    mapDialog(markerTitle, "+8808174066", "Comilla University Road, Shalmanpur 3506", "http://www.comilla.gov.bd/site/tourist_spot/562da145-2147-11e7-8f57-286ed488c766/%E0%A6%B6%E0%A6%BE%E0%A6%B2%E0%A6%AC%E0%A6%A8%20%E0%A6%AC%E0%A7%8C%E0%A6%A6%E0%A7%8D%E0%A6%A7%20%E0%A6%AC%E0%A6%BF%E0%A6%B9%E0%A6%BE%E0%A6%B0");
                } else if (markerTitle.equals("Sajek")) {
                    mapDialog(markerTitle, "+8801886666021", "Dighinala - Sajek Road, Sajek", "https://www.facebook.com/touromadhk");
                } else if (markerTitle.equals("Tajhat Palace")) {
                    mapDialog(markerTitle, "", "Tajhat Road, Rangpur 5400", "http://www.archaeology.gov.bd/");
                } else if (markerTitle.equals("Town Hall")) {
                    mapDialog(markerTitle, "", "Rangpur", "");
                } else if (markerTitle.equals("Mithapukur Bara Mosque")) {
                    mapDialog(markerTitle, "", "Durgapur,Rangpur", "");
                } else if (markerTitle.equals("Begum Rokeya Memorial")) {
                    mapDialog(markerTitle, "", "Pairaband,Rangpur", "");
                } else if (markerTitle.equals("Kellaband Mosque (Masjid)")) {
                    mapDialog(markerTitle, "+8801723577008", "Rangpur - Dinajpur Hwy, Rangpur", "");
                } else if (markerTitle.equals("Itakumari Jamindar Bari")) {
                    mapDialog(markerTitle, "", "Itakumari,Rangpur", "");
                } else if (markerTitle.equals("Manthana Zamindar Bari")) {
                    mapDialog(markerTitle, "", "Fire Station Rd, Rangpur", "");
                } else if (markerTitle.equals("Ratargul, Guainghat Sylhet")) {
                    mapDialog(markerTitle, "", "Sylhet", "");

                } else if (markerTitle.equals("Lala khal")) {
                    mapDialog(markerTitle, "", "Sylhet", "");
                } else if (markerTitle.equals("Tanguar Hao")) {
                    mapDialog(markerTitle, "+8801815162600", "Dharmpasha - Tahirpur Road, 3030", "https://www.facebook.com/TanguarHaorBD/");
                } else if (markerTitle.equals("Sreemongol & Around")) {
                    mapDialog(markerTitle, "", "Sreemangal. Division, Sylhet Division. District, Moulvibazar District", "");
                } else if (markerTitle.equals("Bisnakandi")) {
                    mapDialog(markerTitle, "", "বিছনাকান্দি ,সিলেট", "");
                } else if (markerTitle.equals("Jaflong")) {
                    mapDialog(markerTitle, "", "Balla Ghaut Rd, জাফলং,Sylhet", "");
                } else if (markerTitle.equals("Luvachora")) {
                    mapDialog(markerTitle, "+8801827871420", "Kanaighat,Sylhet", "http://www.fb.me/loobacherra");
                }


                return false;
            }
        });


    }

    public void mapDialog(String title, String phoneNo, String address, String website) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(" Place Informations")
                .setMessage("Title: " + title + "\n" + "Phone: " + phoneNo + "\n" + "Address: " + address + "\n" + "Website: " + website)
                .setPositiveButton("Yes", ((dialogInterface, i) -> {

                }))
                .setCancelable(false)
                .show();

    }


}
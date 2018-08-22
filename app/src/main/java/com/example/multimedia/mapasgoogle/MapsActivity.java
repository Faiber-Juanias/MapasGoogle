package com.example.multimedia.mapasgoogle;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

//Cambiamos la clase de la cual extiende MapsActivity la cual por defecto es FragmentActivity por AppCompatActivity
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.OnInfoWindowClickListener{

    private GoogleMap mMap;
    private Marker markerUno;
    private Marker markerDos;
    private Marker markerTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in sedeSena and move the camera
        LatLng sedeSena = new LatLng(4.6626328, -74.06543420000003);
        mMap.addMarker(new MarkerOptions().position(sedeSena).title("Sede colombia").snippet("Aqui es el lugar en donde estudias."));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sedeSena, 7));

        //Creamos un marcador
        LatLng casa = new LatLng(4.7311534, -74.0995628);
        markerUno = googleMap.addMarker(new MarkerOptions().position(casa).title("Mi casa"));

        //Creamos un marcador
        LatLng centroComercial = new LatLng(4.7114638629507, -74.07325208187103);
        markerDos = googleMap.addMarker(new MarkerOptions().position(centroComercial).draggable(true).title("Centro comercial"));

        //Creamos un marcador
        LatLng portal = new LatLng(4.747839076292171, -74.0951657295227);
        markerTres = googleMap.addMarker(new MarkerOptions().position(portal).title("Portal Suba").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        //Colocamos en escucha cuando se pulse en un marcador
        googleMap.setOnMarkerClickListener(this);
        //Colocamos en escucha cuando se arratre un marcador
        googleMap.setOnMarkerDragListener(this);
        //Colocamos el escuchador para crear un dialogo cuando se pulse un marcador
        googleMap.setOnInfoWindowClickListener(this);
    }

    //Metodo perteneciente a OnMarkerClickListener
    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(markerUno)){
            String lat, lng;
            lat = String.valueOf(markerUno.getPosition().latitude);
            lng = String.valueOf(markerUno.getPosition().longitude);
            Toast.makeText(this, "" + lat + " - " + lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    //Metodo perteneciente a OnMarkerDragListener
    @Override
    public void onMarkerDragStart(Marker marker) {
        //Cuando se inicie a arrastrar el marcador
        if (marker.equals(markerDos)){
            Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        //Cuando se este arrastrando el marcador
        if (marker.equals(markerDos)){
            String newTitle = String.format(Locale.getDefault(), getString(R.string.marker_detail_latlng), marker.getPosition().latitude, marker.getPosition().longitude);
            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        //Cuando se termine de arrastrar el marcador
        if (marker.equals(markerDos)){
            Toast.makeText(this, "Finish", Toast.LENGTH_SHORT).show();
            setTitle(R.string.app_name);
        }
    }

    //Metodo perteneciente a OnInfoWindowClickListener
    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.equals(markerTres)){
            FragmentMessage.newInstance(marker.getTitle(), getString(R.string.mensaje)).show(getSupportFragmentManager(), null);
        }
    }
}

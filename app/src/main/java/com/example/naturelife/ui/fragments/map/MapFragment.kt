package com.example.naturelife.ui.fragments.map

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.naturelife.databinding.FragmentMapBinding
import com.example.naturelife.services.TrackingService
import com.example.naturelife.utils.PermissionsUtil
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class MapFragment : Fragment(), EasyPermissions.PermissionCallbacks {
    private var binding: FragmentMapBinding? = null
    private val viewModel: MapViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestPermissions()

        binding?.run {
            mapButton.setOnClickListener {
                sendCommandToService(TrackingService.ACTION_START_OR_RESUME_SERVICE)
                viewModel.addRoute()
            }
        }
    }

    private fun sendCommandToService(action: String) {
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding?.mapview?.onStart()
    }

    override fun onStop() {
        binding?.mapview?.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    private fun requestPermissions() {
        if (!PermissionsUtil.hasLocationPermissions(requireContext())) {
            if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.Q)) {
                EasyPermissions.requestPermissions(
                    this,
                    "Для работы приложения необходимо разрешение на доступ к геопозиции.",
                    REQUEST_CODE_LOCATION_PERMISSION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                EasyPermissions.requestPermissions(
                    this,
                    "Для работы приложения необходимо разрешение на доступ к геопозиции.",
                    REQUEST_CODE_LOCATION_PERMISSION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                )
            } else {
                EasyPermissions.requestPermissions(
                    this,
                    "Для работы приложения необходимо разрешение на доступ к геопозиции.",
                    REQUEST_CODE_LOCATION_PERMISSION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                    Manifest.permission.FOREGROUND_SERVICE_LOCATION
                )
            }
        }
    }

    companion object {
        const val REQUEST_CODE_LOCATION_PERMISSION = 0
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build()
                .show()
        } else {
            requestPermissions()
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        // Permissions granted, nothing to do
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}
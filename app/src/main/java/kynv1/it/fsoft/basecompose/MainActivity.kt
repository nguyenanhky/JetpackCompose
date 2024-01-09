package kynv1.it.fsoft.basecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kynv1.it.fsoft.basecompose.ui.cartlog.category.CategoryScreen
import kynv1.it.fsoft.basecompose.ui.cartlog.product.ProductDetailScreen
import kynv1.it.fsoft.basecompose.ui.checkout.CheckoutScreen
import kynv1.it.fsoft.basecompose.ui.checkout.CheckoutSuccessScreen
import kynv1.it.fsoft.basecompose.ui.customer.Address
import kynv1.it.fsoft.basecompose.ui.customer.AddressBookNavigation
import kynv1.it.fsoft.basecompose.ui.customer.AddressBookScreen
import kynv1.it.fsoft.basecompose.ui.customer.AddressDetailScreen
import kynv1.it.fsoft.basecompose.ui.customer.AddressNavType
import kynv1.it.fsoft.basecompose.ui.customer.MyAccountScreen
import kynv1.it.fsoft.basecompose.ui.home.HomeScreen
import kynv1.it.fsoft.basecompose.ui.theme.BaseComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController();

    BaseComposeTheme {
        NavHost(navController = navController, startDestination = "home") {
            Log.d("KyNV1", "MainApp")
            composable("home") {
                HomeScreen(
                    openCategoryAction = { navController.navigate("category") },
                    openMyAccountScreen = { navController.navigate("MyAccount") },
                    editCustomerInfo = {},
                    openAddressBook = {
                        val address = Address(id = 1, street = "Tran Hung Dao", city = "Nam Dinh")
                        navController.navigate(AddressBookNavigation.createRoute(addresses = address))
                    }
                )

            }

            composable(
                route = AddressBookNavigation.route,
                arguments = listOf(
                    navArgument(AddressBookNavigation.addressArg){
                        nullable = true
                        type = AddressNavType()
                    }
                )
            ){
                val address = AddressBookNavigation.getAddress(it)
                AddressBookScreen(addresses = listOf(address)) {
                    
                }
                
            }
            composable("category") {
                CategoryScreen(openProductDetail = { productId ->
                    navController.navigate(route = "productDetail/$productId")
                })
            }

            composable(
                // received data
                route = "productDetail/{productId}",
                arguments = listOf(navArgument(name = "productId") {
                    type = NavType.StringType
                })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")
                requireNotNull(productId)
                ProductDetailScreen(productId = productId, checkout = { cartId, customerId ->
                    navController.navigate("checkout/{$cartId}/{$customerId}")
                })
            }

            composable(
                // received data
                route = "checkout/{cartId}/{customerId}",
                arguments = listOf(
                    navArgument("cartId") {
                        type = NavType.StringType
                    },
                    navArgument("customerId") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val cartId = backStackEntry.arguments?.getString("cartId")
                val customerId = backStackEntry.arguments?.getString("customerId")
                requireNotNull(cartId)
                requireNotNull(customerId)
                CheckoutScreen(cartId = cartId, customerId = customerId, placeOrderAction = {
                    navController.navigate("checkoutSuccess")
                }, backTrack = {
                    navController.popBackStack()
                })
            }

            composable(route = "checkoutSuccess") {
                CheckoutSuccessScreen(goHomeAction = {
                    navController.popBackStack("home", inclusive = false, saveState = true)
                }, viewOrderDetailAction = {})
            }

            composable(route = "MyAccount") {
                MyAccountScreen(navController= navController,openAddressScreen = { addressId ->
                    val route =
                        if (addressId == null) "addressDetail" else "addressDetail?addressId=$addressId"
                    navController.navigate(route)
                })
            }

            composable(
                route = "addressDetail?addressId={addressId}",
                arguments = listOf(navArgument(name = "addressId") {
                    type = NavType.StringType
                    nullable = true
                })
            ) { backStackEntry ->
                val address = backStackEntry.arguments?.getString("addressId")
                AddressDetailScreen(addressId = address, saveAddressAndBack = {addressId->
                    navController.previousBackStackEntry?.savedStateHandle?.set("new_address_id",addressId)
                    navController.popBackStack()
                })
            }

        }
    }
}


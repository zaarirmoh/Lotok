package com.example.lotok.ui.components.navigationBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.lotok.ui.theme.GrayNav
import com.example.lotok.ui.theme.RedPrimary

@Composable
fun MyNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    NavigationBar {
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        items.forEachIndexed { index,item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = if(index == selectedItemIndex) RedPrimary
                        else GrayNav
                    )
                },
                label = {
                    Text(text = item.title)
                },
            )
        }
    }
}


/*
    androidx.compose.material3.NavigationBar {
        NavigationBarItem(
            selected = ,
            onClick = { /*TODO*/ },
            icon = { /*TODO*/ },
            label = { Text(text = ) }
        )
        NavigationBarItem(
            selected = ,
            onClick = { /*TODO*/ },
            icon = { /*TODO*/ },
            label = { Text(text = ) }
        )
        NavigationBarItem(
            selected = ,
            onClick = { /*TODO*/ },
            icon = { /*TODO*/ },
            label = { Text(text = ) }
        )
        NavigationBarItem(
            selected = ,
            onClick = { /*TODO*/ },
            icon = { /*TODO*/ },
            label = { Text(text = ) }
        )
        NavigationBarItem(
            selected = ,
            onClick = { /*TODO*/ },
            icon = { /*TODO*/ },
            label = { Text(text = ) }
        )
    }
 */
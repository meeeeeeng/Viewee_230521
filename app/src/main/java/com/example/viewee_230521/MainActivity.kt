/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelab.basiclayouts

import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
//import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewee_230521.R
import org.w3c.dom.Text
import kotlin.math.round
//mport com.codelab.basiclayouts.ui.theme.MySootheTheme
import androidx.compose.material.TextField as TextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  //ShowTotalFeedback()
            //VieweeBottomNavigation()


            MyApp()

        }
    }
}





//------------------------------------------------------------------------------------------------------




// Step: Search bar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier = Modifier

) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon={
            Icon(Icons.Default.Search, contentDescription=null)
        },
        placeholder ={
            Text("Search")
                     //Text(text="원하시는 검색어를 입력해주세요")

        },
        colors=TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier= Modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )
    // Implement composable here
}



// Step: Favorite collection card - Material Surface
///메인화면_면접결과
@Composable
fun MainFeedbackCard(
    //  @DrawableRes drawable: Int,
    text0: String,
    j : Int = 0,
    modifier: Modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
) {
    var usBlue = Color(red = 37, green = 88, blue = 171)
    val list = (1..10).map { it.toString() }
    
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier= Modifier
            //.alpha(0.2f)
    ) {
        Row(
          //verticalAlignment = Alignment.CenterVertically,
            modifier= Modifier
                .width(200.dp)
                .height(200.dp)
                .background(usBlue.copy(alpha = 0.2f))
                .alpha(0.5f)
        ){
            //Image(
            //  painter = painterResource(drawable),
            //     contentDescription = null,
            //     contentScale = ContentScale.Crop,
            //     modifier = Modifier.size(56.dp)
            //  )





            Text(text = list[j].toString(),
                modifier= Modifier
                    .weight(1f, fill = true)
                    .padding(
                        horizontal = 25.dp,
                        vertical = 10.dp
                    )
                ,textAlign = TextAlign.Left
                ,color = usBlue
                ,fontSize = 70.sp

                // ,style = MaterialTheme.typography.h2
                )


            Column(modifier= Modifier
                .size(120.dp)
                  , verticalArrangement = Arrangement.Center
                ) {


                Text(text= text0,
                    modifier= Modifier
                        .padding(
                            horizontal = 2.dp,
                            vertical = 2.dp
                        )
                   // ,textAlign = TextAlign.Start
                    ,fontSize = 20.sp

                    // ,style = MaterialTheme.typography.h5
                   )

                Text(
                    stringResource(id =  R.string.main_title_day),
                    modifier= Modifier
                        .padding(
                            horizontal = 2.dp,
                            vertical = 2.dp
                        )
                    ,fontSize = 10.sp

                   )

            }
        }

    }
    // Implement composable here
}



///메인화면_면접세부결과
@Composable
fun DetailFeedbackCard(
    //  @DrawableRes drawable: Int,
    text1: String,
    k : Int = 0,

    modifier: Modifier = Modifier
) {

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier= Modifier
        .clip(RoundedCornerShape(10.dp))

    ) {var usBlue = Color(red = 37, green = 88, blue = 171)
        Row(
            verticalAlignment = Alignment.CenterVertically
            ,modifier= Modifier
                .width(90.dp)
                .background(usBlue.copy(alpha = 0.05f))
                //.padding(5.dp)
                .border(1.dp,(usBlue.copy(alpha = 0.5f)),RoundedCornerShape(10.dp))



        ){
            //Image(
            //  painter = painterResource(drawable),
            //     contentDescription = null,
            //     contentScale = ContentScale.Crop,
            //     modifier = Modifier.size(56.dp)
            //  )
            //val list = (1..text1.count()).map { it.toString() }



            Text(text= text1,
                modifier= Modifier

                    .padding(
                        horizontal = 5.dp,
                        vertical = 5.dp
                    ),
                textAlign = TextAlign.Left
                ,fontSize = 12.sp
                , color = Color.Gray


            )

                //style = MaterialTheme.typography.h6)

        }

    }
    // Implement composable here
}



// 메인 화면_면접 결과
@Composable
fun MainFeedbackCardGrid(
    modifier: Modifier = Modifier
) {
    var j = 0
    val list = (1..10).map { it.toString() }

    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 20.dp)

        ,verticalArrangement = Arrangement.spacedBy(8.dp)
        ,horizontalArrangement = Arrangement.spacedBy(8.dp)
        ,modifier = Modifier.height(200.dp),
        rows = GridCells.Fixed(1)){

        items(alignMainFeedbackData.size) { index ->
            MainFeedbackCard(
                // drawable = item.drawable,
                text0 = alignMainFeedbackData.get(j++)
            )

        }
    }

}

// 메인화면_면접세부결과
@Composable
fun DetailFeedbackCardGrid(
    modifier: Modifier = Modifier

) {
    var i = 0
    val list = (1..10).map { it.toString() }

    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 20.dp)
        ,verticalArrangement = Arrangement.spacedBy(20.dp)
        ,horizontalArrangement = Arrangement.spacedBy(20.dp)
        ,modifier = Modifier.height(180.dp)
        ,rows = GridCells.Fixed(2)

        ,content = {

            items(alignDetailFeedbackData.size) { index ->

                DetailFeedbackCard(
                    // drawable = item.drawable,

                    text1 = list[index] + " " +alignDetailFeedbackData.get(i++)
                )

            }
        })
    // Implement composable here
}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(
    @StringRes title :Int,
    userName:String="김길동",
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) { Column(modifier) {

    Text("$userName"+stringResource(id=title)
        ,style = MaterialTheme.typography.h6
        , color = Color.DarkGray
        ,modifier= Modifier
            .paddingFromBaseline(
                top = 45.dp,
                bottom = 15.dp
            )
            .padding(horizontal = 20.dp))
    content()
}
    // Implement composable here
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Implement composable here
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(20.dp))
        androidx.compose.foundation.Image(painterResource(
            R.drawable.main_logo)
            , contentDescription = null)
        // SearchBar(
        //   Modifier.padding(horizontal = 16.dp))
        HomeSection(title =R.string.main_title ) {
            MainFeedbackCardGrid() }
        HomeSection(title = R.string.Detail_title) {
            DetailFeedbackCardGrid()
        }
        Spacer(Modifier.height(20.dp))
    }
}

// Step: Bottom navigation - Material
@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = Color(red = 245, green = 246, blue = 248),//MaterialTheme.colors.background,
        modifier= Modifier){
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Play")
            },
            selected = true,
            onClick = {}
        )




        BottomNavigationItem(
            selected=false,
            onClick = {  },
            icon ={
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null
                )
            },
            label= {
                Text("Play")
            }
        )
        BottomNavigationItem(
            selected=false,
            onClick = {  },
            icon ={
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null
                )            },
            label= {
                Text("My page")
            }
        )


    }

}



// Step: MySoothe App - Scaffold

@Composable
fun MyApp() {
    MaterialTheme {
        Scaffold( //backgroundColor = Color(red = 231, green = 236, blue = 244),
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))

        }
    }

}

private val alignDetailFeedbackData = arrayOf(
    "자기소개", "경험",
    "직무1",  "직무2",
    "경력1","경력2",
    "적성1","적성2",


)

private val alignMainFeedbackData = arrayOf(

    "230313","230413","230513","230613",
    "230313","230413","230513","230613",

    )





@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MyPreview() {
    MyApp()
}



@Preview
@Composable
fun LazyVerticalGridDemo(){
    val list = (1..10).map { it.toString() }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    backgroundColor = Color.Red,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    elevation = 8.dp,
                ) {
                    Text(
                        text = list[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    )
}
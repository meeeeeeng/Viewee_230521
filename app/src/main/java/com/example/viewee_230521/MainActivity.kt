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

package com.example.viewee_230521

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.lerp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.example.viewee_230521.ui.theme.BackgroundGrey
import com.example.viewee_230521.ui.theme.CustomOrange
import com.example.viewee_230521.ui.theme.UsBlue
import com.example.viewee_230521.ui.theme.BackgroundGrey
import com.example.viewee_230521.ui.theme.UsBlue
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  //ShowTotalFeedback()
            MyApp()
           // DataInputScreen()
        }
    }
}

@Composable
fun MainTopBar(
    modifier: Modifier = Modifier
) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier
                .width(100.dp)
                .height(27.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.main_logo),
            contentDescription = null
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                20.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .clickableWithoutRipple(
                        interactionSource = interactionSource,
                        onClick = { }
                    ),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                contentDescription = "search",
            )
            Icon(
                modifier = Modifier
                    .width(32.dp)
                    .height(18.dp)
                    .clickableWithoutRipple(
                        interactionSource = interactionSource,
                        onClick = { }
                    ),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_menu),
                contentDescription = "menu"
            )
        }
    }
}

// 메인화면_면접결과
@Composable
fun MainFeedbackCard(
    modifier: Modifier = Modifier,
    index: Int
) {
    var usBlue = Color(red = 37, green = 88, blue = 171)

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(usBlue.copy(alpha = 0.2f))
                .alpha(0.5f)
        ) {
            Text(
                text = (index + 1).toString(),
                modifier = Modifier
                    .weight(1f, fill = true)
                    .padding(
                        horizontal = 25.dp,
                        vertical = 10.dp
                    ),
                textAlign = TextAlign.Left,
                color = usBlue,
                fontSize = 70.sp
            )
            Column(
                modifier = Modifier
                    .size(120.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = alignMainFeedbackData[index],
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp),
                    fontSize = 20.sp
                )
                Text(
                    stringResource(id = R.string.main_title_day),
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp),
                    fontSize = 10.sp
                )
            }
        }
    }
}


// 메인화면_면접결과(Grid)
@Composable
fun MainFeedbackCardGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(200.dp),
        rows = GridCells.Fixed(1)
    ) {

        items(alignMainFeedbackData.size) { index ->
            MainFeedbackCard(
                index = index
            )
        }
    }
}

// 메인화면_면접세부결과
@Composable
fun DetailFeedbackCard(
    modifier: Modifier = Modifier,
    detailTitleIndex: Int,
    detailTitle: String,
) {


    Box(
        modifier = modifier
            .background(UsBlue.copy(alpha = 0.05f))
            .border(1.dp, (UsBlue.copy(alpha = 0.5f)), RoundedCornerShape(10.dp)),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = (detailTitleIndex + 1).toString(),
                modifier = Modifier,
                textAlign = TextAlign.Left,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
                color = Color.Gray
            )
            Text(
                text = detailTitle,
                modifier = Modifier,
                textAlign = TextAlign.Left,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

// 메인화면_면접세부결과(Grid)
@Composable
fun DetailFeedbackCardGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        // 그리드 각 항목들이 사이즈 비율이 안 맞았던 이유
        // -> LazyHorizontalGrid 높이에 고정 값 주려면 패딩 값이나 space 값 도 계산 해서 해줘야…
        modifier = modifier.height(220.dp),
        rows = GridCells.Fixed(2),
        content = {
            items(alignDetailFeedbackData.size) { index ->
                DetailFeedbackCard(
                    modifier = Modifier.size(100.dp),
                    detailTitleIndex = index,
                    detailTitle = alignDetailFeedbackData[index]
                )
            }
        })
}


@Composable
fun HomeSection(
    @StringRes title: Int,
    username: String = "김길동",
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            "$username" + stringResource(id = title),
            style = MaterialTheme.typography.h6,
            color = Color.DarkGray,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 45.dp,
                    bottom = 15.dp
                )
                .padding(horizontal = 20.dp)
        )
        content()
    }
    // Implement composable here
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier.fillMaxSize()) {
        MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 25.dp))
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(1.dp)
//                .background(Color.Gray.copy(alpha = 0.5f))
//        )
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HomeSection(title = R.string.main_title) {
                MainFeedbackCardGrid()
            }
            HomeSection(title = R.string.Detail_title) {
                DetailFeedbackCardGrid()
            }
//        Spacer(Modifier.height(20.dp))
        }
    }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = Color(
            red = 245,
            green = 246,
            blue = 248
        ),//MaterialTheme.colors.background,
        modifier = Modifier
    ) {
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
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null
                )
            },
            label = {
                Text("Play")
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null
                )
            },
            label = {
                Text("My page")
            }
        )
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(
                Modifier.padding(padding)
            )
        }
    }

}
//===================================== 면접플레이버튼 화면 ====================================
@Composable
fun Playbutton(modifier: Modifier){

    Image(imageVector =ImageVector.vectorResource
        (id = R.drawable.ic_play_button),
        contentDescription =null,

        modifier= Modifier
            .padding(top = 180.dp)
            .clickable { }
            .fillMaxWidth()



    )



}

@Composable
fun PlaybuttonScreen(){


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))

        Surface(modifier = Modifier) {




                    Box(modifier = Modifier) {
                        Playbutton(modifier = Modifier.padding(top = 70.dp))
                        Column(modifier = Modifier
                            .height(900.dp)
                            .padding(vertical = 0.dp),
                            verticalArrangement = Arrangement.Center
                            ) {

                            CustomTitleText(modifier = Modifier.padding(top = 90.dp), "오늘의 면접 시작하기")
                            /* Text(
                                        text = "오늘의 면접 시작하기",
                                        modifier = Modifier
                                            .padding(vertical = 10.dp)
                                            .fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        fontStyle = FontStyle.Normal,
                                        fontSize = 15.sp,
                                        color = Color.Gray
                                    )*/


                            QuitButton(
                                modifier = Modifier

                                    .padding(vertical= 5.dp,horizontal = 155.dp),
                                onClick = {})

                        }
                    }
            }

       }
    }


//=============================== 면접준비 화면 =======================================


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreparePlayPagerScreen(modifier: Modifier,images: List<Int>) {
    val pagerState = rememberPagerState()


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundGrey)
        , verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(pageCount = 5, state = pagerState) {
                Image(modifier= Modifier.padding(vertical = 40.dp),
                    painter = painterResource(id = images[it]),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
            }

            Text("면접 화면은 어둡지 않은,\n밝은 환경에서 진행 해주세요",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                fontSize = 13.sp,
                color = Color.Gray)

            var pageCount = 3
            //  pagerState = pagerState

            Row(
                Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(10.dp)
                    , horizontalArrangement = Arrangement.Center

            ) {
                repeat(pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(5.dp)


                    )
                }
            }

        }
    }







@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PrepareScreen(
    ){


    Column(modifier = Modifier
        .fillMaxSize()
        .background(BackgroundGrey)
        ,verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
       // MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))
      //  Surface(modifier = Modifier) {


            CustomTitleText(modifier = Modifier
                .fillMaxWidth()

                .padding(top = 60.dp, bottom = 10.dp),"면접 진행 시 꼭 지켜주세요!")

            PreparePlayPagerScreen(modifier=Modifier.padding(vertical = 30.dp), images = prepareImageData)

            NextButton(
                modifier = Modifier.padding(horizontal = 30.dp),
                onClick = {}
            )
    }

                




}



@Preview(showBackground =  true,widthDp = 360, heightDp = 640)
@Composable
fun  PrepareScreenPreview() {

    PrepareScreen( )
}




////준비화면_카메라화면_준비_단계
@Composable
fun PrepareCam() {

    Column(modifier = Modifier
        .fillMaxSize(.5f)
        .background(BackgroundGrey)
        ,verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
         MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))



            Column(modifier = Modifier
                .fillMaxSize()
                .background(BackgroundGrey)
                ,verticalArrangement = Arrangement.Center
                , horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("조용하고 밝은 장소에서 카메라를 \n" +
                        "눈높이에 맞춰 고정시킨 후 , \n" +
                        "면접을 시행해주세요.\n" +
                        "\n" +
                        "총 N개의 질문으로 생각시간은 N초, \n" +
                        "답변시간은 N초입니다.\n" +
                        "\n" +
                        "준비가 되셨다면 다음버튼을 눌러 주세요.",

                    Modifier
                        .fillMaxWidth()

                       // .padding(bottom = 300.dp),
                    ,textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = UsBlue

                    )
                Image(modifier= Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                    painter = painterResource(id = R.drawable.ic_prepare_cam),

                    contentDescription = ""
                    )

                NextButton(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    onClick = {}
                )
            }
        }
    }





@Preview(showBackground =  true,widthDp = 360, heightDp = 640)
@Composable
fun PrepareCamScreen() {

    PrepareCam()

}

//=================================== 정보기입화면 =======================================


// 다음 버튼
@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .clip(RoundedCornerShape(10.dp)),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = UsBlue
        )
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_nextbutton),
            contentDescription = "next"
        )
    }
}

// 종료 버튼
@Composable
fun QuitButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier.clickable { onClick() },

        text = "종료하기",
        fontSize = 13.sp,
        color = CustomOrange,
        textDecoration = TextDecoration.Underline
    )
}

// 정보 입력 카드
@Composable
fun DataInputCard(
    modifier: Modifier = Modifier,
    dataName: String,
    dataValue: String,
    onTextChanged: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dataName,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left,
            fontStyle = FontStyle.Normal,
            fontSize = 13.sp,
            color = Color.Gray
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            value = dataValue,
            onValueChange = { onTextChanged(it) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BackgroundGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun CustomTitleText(
    modifier: Modifier = Modifier,
    text: String = "자신의 정보를 입력해주세요.",
) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = UsBlue
    )
}

// 정보 입력 화면 1
@Composable
fun DataInputScreen1(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTitleText(
            modifier = Modifier.padding(top = 40.dp),
            text = "자신의 정보를 입력해주세요.",
        )
        Column(
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(
                10.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            DataInputCard(
                dataName = "이름",
                dataValue = "",
                onTextChanged = {}
            )
            DataInputCard(
                dataName = "생년월일",
                dataValue = "",
                onTextChanged = {}
            )
            DataInputCard(
                dataName = "학력",
                dataValue = "",
                onTextChanged = {}
            )
            DataInputCard(
                dataName = "경력",
                dataValue = "",
                onTextChanged = {}
            )
        }
        NextButton(
            modifier = Modifier.padding(horizontal = 30.dp),
            onClick = {}
        )
    }
//        QuitButton(onClick = {})
}


// 정보 입력 화면 2
@Composable
fun DataInputScreen2(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTitleText(
            modifier = Modifier.padding(top = 40.dp),
            text = "자신의 정보를 입력해주세요.",
        )
        Column(
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(
                10.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            DataInputCard(
                dataName = "지원 직무",
                dataValue = "",
                onTextChanged = {}
            )
            DataInputCard(
                dataName = "자격증 / 어학 / 수상내역",
                dataValue = "",
                onTextChanged = {}
            )
            DataInputCard(
                dataName = "보유기술 및 능력",
                dataValue = "",
                onTextChanged = {}
            )
        }
        NextButton(
            modifier = Modifier.padding(horizontal = 30.dp),
            onClick = {}
        )
    }
//        QuitButton(onClick = {})
}

// 정보 입력 화면 3
@Composable
fun DataInputScreen3(
    modifier: Modifier = Modifier,
    resumeText: String,
    onTextChanged: (String) -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTitleText(
            modifier = Modifier.padding(top = 40.dp),
            text = "자신의 자기소개서를 입력해주세요.",
        )
        Column(
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(
                10.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(10.dp)),
                value = resumeText,
                onValueChange = { onTextChanged(it) },
                placeholder = {
                    Text(
                        text = "자기소개서: 600자 제한",
                        color = Color.Gray.copy(.5f)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = BackgroundGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        NextButton(
            modifier = Modifier.padding(horizontal = 30.dp),
            onClick = {}
        )
    }
//        QuitButton(onClick = {})
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DataInputPreview1() {

    DataInputScreen1()
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DataInputPreview2() {

    DataInputScreen2()
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DataInputPreview3() {

    DataInputScreen3(
        resumeText = "",
        onTextChanged = {}
    )
}


private val alignDetailFeedbackData = arrayOf(
    "자기소개", "경험",
    "직무1", "직무2",
    "경력1", "경력2",
    "적성1", "적성2",
)

private val alignMainFeedbackData = arrayOf(
    "230313", "230413", "230513", "230613",
    "230313", "230413", "230513", "230613",
)


private val prepareImageData = listOf(
    R.drawable.ic_prepare1 ,
    R.drawable.ic_prepare2 ,
    R.drawable.ic_prepare3,
    R.drawable.ic_prepare3,


    )

private val prepareData = listOf(
    R.drawable.ic_prepare1 to R.string.Prepare_1,
    R.drawable.ic_prepare2 to R.string.Prepare_2,
    R.drawable.ic_prepare3 to R.string.Prepare_3,

).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

fun Modifier.clickableWithoutRipple(
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
) = composed(
    factory = {
        this.then(
            Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            )
        )
    }
)


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MyPreview() {
    MyApp()
}

@Preview(widthDp = 500, heightDp = 500)
@Composable
fun MyPreview2() {
    MyApp()
}

@Preview(showBackground = true)
@Composable
fun MainTopBarPreview() {
    MainTopBar()
}

@Preview(showBackground = true,widthDp = 360, heightDp = 640)
@Composable
fun PlaybuttonScreenPreview(){
    PlaybuttonScreen()
}



package com.example.quizler.feature.main.new_question

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.quizler.di.viewmodel.CategoriesListState
import com.example.quizler.domain.data.local.entity.CategoryModeEntity
import com.example.quizler.domain.model.QuizMode
import com.example.quizler.feature.main.home.quiz_mode.usecase.GetModesCategoryUseCase
import com.example.quizler.util.State
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuestionViewModel
@Inject constructor(
    private val useCase: GetModesCategoryUseCase,
    var bindingModel: NewQuestionBindingModel
) : ViewModel(), QuestionCreationListener {

    fun getCategories() = useCase.fetch().asLiveData()

    override fun onSave() {
        val json = Gson()
        val jsonBindingModel = json.toJson(bindingModel)
        Log.d("NewQuestionViewModel", "onSave:\n$jsonBindingModel")
    }

    override fun onFieldsReset() {
        bindingModel.apply {
            answerA = ""
            answerB = ""
            answerC = ""
            answerD = ""
            isAnswerCCorrect = false
            isAnswerBCorrect = false
            isAnswerACorrect = true
            isAnswerDCorrect = false
            question = ""
        }
    }
}

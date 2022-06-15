package com.arcieri.wagner.mvvm_recipebook.repository

import com.arcieri.wagner.mvvm_recipebook.data.RecipeBookDatabaseDAO
import com.arcieri.wagner.mvvm_recipebook.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RecipeBookRepository @Inject constructor(private val recipeBookDatabaseDAO: RecipeBookDatabaseDAO) {

    suspend fun addRecipe(recipe: Recipe) = recipeBookDatabaseDAO.insertRecipe(recipe)

    suspend fun updateRecipe(recipe: Recipe) = recipeBookDatabaseDAO.updateRecipe(recipe)

    suspend fun deleteRecipe(recipe: Recipe) = recipeBookDatabaseDAO.deleteRecipe(recipe)

    suspend fun deleteAllRecipes() = recipeBookDatabaseDAO.deleteAllRecipes()

    fun getAllRecipes(): Flow<List<Recipe>> =
        recipeBookDatabaseDAO.getRecipes().flowOn(Dispatchers.IO).conflate()

}
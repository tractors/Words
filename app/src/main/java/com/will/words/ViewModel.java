package com.will.words;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private WordRepository repository;
    private boolean isUpdate = false;
    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return repository.getAllWordsLive();
    }

    public LiveData<List<Word>> findWordsWithPatten(String patten){
        return repository.findWordsWithPatten(patten);
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }

    public void insertWords(Word... words){
        repository.insertWords(words);
    }

    public void updateWords(Word... words){
        repository.updateWords(words);
    }

    public void deleteWords(Word... words){
        repository.deleteWords(words);
    }

    public void deleteAllWords(){
        repository.deleteAllWords();
    }


    /**
     * 入集合和两个角标使集合中元素交换位置
     * @param list
     * @param index1
     * @param index2
     * @param <E>
     */
    public static <E> void swap(List<E> list,int index1,int index2) {
        //定义第三方变量
        E e=list.get(index1);
        //交换值
        list.set(index1, list.get(index2));
        list.set(index2, e);
    }
}

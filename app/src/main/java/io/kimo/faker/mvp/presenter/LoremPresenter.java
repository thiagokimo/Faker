package io.kimo.faker.mvp.presenter;

import android.content.Context;

import io.kimo.faker.mvp.BasePresenter;
import io.kimo.faker.mvp.view.LoremView;
import io.kimo.lib.faker.Faker;

public class LoremPresenter extends BasePresenter {

    public LoremPresenter(LoremView view, Context context) {
        super(view, context);
    }

    @Override
    public void configureMainView() {
        LoremView loremView = (LoremView) view;

        loremView.updateCharacterExample(Faker.with(context).Lorem.character());
        loremView.updateCharactersExample(Faker.with(context).Lorem.characters());

        loremView.updateWordExample(Faker.with(context).Lorem.word());
        loremView.updateWordsExample(Faker.with(context).Lorem.words());

        loremView.updateSentenceExample(Faker.with(context).Lorem.sentence());
        loremView.updateSentencesExample(Faker.with(context).Lorem.sentences());

        loremView.updateParagraphExample(Faker.with(context).Lorem.paragraph());
        loremView.updateParagraphsExample(Faker.with(context).Lorem.paragraphs());
    }

    @Override
    public void destroyView() {}
}

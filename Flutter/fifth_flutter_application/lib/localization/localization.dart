import 'dart:ui';
import 'package:flutter/widgets.dart';

class AppLocalizations {
  final Locale locale;

  AppLocalizations(this.locale);

  static Map<String, Map<String, String>> _localizedValues = {
    'en': {
      'app_title': 'Article Feed',
      'add_article': 'Add New Article',
      'title': 'Title',
      'description': 'Description',
      'content': 'Content',
      'image_url': 'Image URL',
      'submit': 'Submit',
      'date': 'Date',
      'name': 'Name',
      'liked_articles': 'Liked Articles',
      'category': 'Category',
      'get_started': 'Get Started',
      'filter_by_category': 'Filter by Category',
      'all': 'All',
      'no_articles': 'No articles available',
      'article_detail': 'Article Detail',
      'profile': 'Profile',
      'category_empty': 'Category cannot be empty', // New key
    },
    'ta': {
      'app_title': 'கட்டுரை ஊட்டம்',
      'add_article': 'புதிய கட்டுரை சேர்',
      'title': 'தலைப்பு',
      'description': 'விளக்கம்',
      'content': 'உள்ளடக்கம்',
      'image_url': 'பட URL',
      'submit': 'சமர்ப்பி',
      'date': 'தேதி',
      'name': 'பெயர்',
      'liked_articles': 'பிடித்த கட்டுரைகள்',
      'category': 'வகை',
      'get_started': 'தொடங்கு',
      'filter_by_category': 'வகை வாரியாக வடிகட்டவும்',
      'all': 'அனைத்தும்',
      'no_articles': 'கட்டுரைகள் இல்லை',
      'article_detail': 'கட்டுரை விவரம்',
      'profile': 'சுயவிவரம்',
      'category_empty': 'வகை காலியாக இருக்கக்கூடாது', // Tamil translation
    },
  };

  static AppLocalizations of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations) ??
        AppLocalizations(const Locale('en'));
  }

  String translate(String key) {
    return _localizedValues[locale.languageCode]?[key] ??
        _localizedValues['en']![key]!;
  }

  static const LocalizationsDelegate<AppLocalizations> delegate =
      _AppLocalizationsDelegate();
}

class _AppLocalizationsDelegate
    extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  bool isSupported(Locale locale) {
    return ['en', 'ta'].contains(locale.languageCode);
  }

  @override
  Future<AppLocalizations> load(Locale locale) async {
    return AppLocalizations(locale);
  }

  @override
  bool shouldReload(_AppLocalizationsDelegate old) => false;
}

import { Inject, Injectable } from '@angular/core';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';

const STORAGE_KEY = 'profile';

@Injectable({
  providedIn: 'root'
})
export class UserProfileServiceService {

  constructor(@Inject(SESSION_STORAGE) private storage: StorageService) { }

  public getUserProfile(): string {
    const profile: string = this.storage.get(STORAGE_KEY);
    return profile;
  }
  public setUserProfile(profile: string) {
    this.storage.set(STORAGE_KEY, profile);
  }
}

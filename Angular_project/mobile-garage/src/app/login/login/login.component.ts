import { HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Subject, Subscription } from 'rxjs';
import { BackendService } from 'src/app/backend/backend.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  form: FormGroup;
  loading = false;
  submitted = false;
  isLoginFail = false;
  public username = '';
  public password = '';
  public errorSubscription: Subscription;

  constructor(private backendService: BackendService) { }


  onSubmit() {
    this.submitted = true;

    const body = new HttpParams()
      .set('username', this.username)
      .set('password', this.password)
      .set('grant_type', 'password');

    this.backendService.sendToAuth(body);
    this.errorSubscription = this.backendService.authStatus.subscribe(authStatus => {
      if (authStatus.status != 200) {
        this.isLoginFail = true;
        this.loading = false
      }
    });

    this.loading = true;
  }

  public onDestroy(): void {
    if (this.errorSubscription) {
      this.errorSubscription.unsubscribe();
    }
  }

}

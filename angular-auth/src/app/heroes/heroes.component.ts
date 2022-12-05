import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';
import { HEROES } from '../mock-heroes';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes : Hero[] = [];

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
    this.loadHeroes();
  }

  loadHeroes(){
    this.heroService.getHeroes().subscribe(result => {
      this.heroes = result;
    })
  }

}

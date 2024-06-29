<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsToMany;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Concours extends Model
{
    protected $fillable = ['libelle', 'description', 'image'];
    use HasFactory;

    public function matieres(): BelongsToMany{
        return $this->belongsToMany(Matiere::class,'matiere_concours', 'concour_id','matiere_id');
    }

 /**
     * Get all of the abonnements for the Concours
     *
     * @return \Illuminate\Database\Eloquent\Relations\HasMany
     */
    public function abonnements(): HasMany
    {
        return $this->hasMany(Abonnements::class, 'concours_id');
    }
}
